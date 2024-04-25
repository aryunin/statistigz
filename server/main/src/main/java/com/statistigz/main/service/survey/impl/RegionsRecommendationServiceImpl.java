package com.statistigz.main.service.survey.impl;

import com.statistigz.common.dto.survey.SurveyResultDTO;
import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.survey.Answer;
import com.statistigz.main.entity.survey.Question;
import com.statistigz.main.entity.survey.SurveyResult;
import com.statistigz.main.exception.ServiceException;
import com.statistigz.main.repository.RegionRepository;
import com.statistigz.main.service.survey.RegionsRecommendationService;
import com.statistigz.main.service.survey.SurveyResultService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionsRecommendationServiceImpl implements RegionsRecommendationService {
    @Value("${services.classifier.host}")
    private String HOST;
    @Value("${services.classifier.port}")
    private String PORT;
    @Value("${services.classifier.protocol}")
    private String PROTOCOL;
    @Value("${services.classifier.context-path}")
    private String PATH;
    @Value("${services.classifier.timeout}")
    private int TIMEOUT;

    private final String serviceName = "classifier";

    private final RestTemplate restTemplate = new RestTemplate(); // TODO bean
    private final RegionRepository regionRepository;
    private final SurveyResultService surveyResultService;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class RegionsResponse {
        private List<Integer> regions;
    }

    @Override
    public List<Region> processSurveyResult(SurveyResult surveyResult) {
        List<Integer> answers = surveyResult.getAnswers()
                .stream()
                .map(Answer::getQuestion)
                .sorted(Comparator.comparing(Question::getOrderIdx))
                .map(Question::getOrderIdx)
                .toList();

        SurveyResultDTO requestObject = surveyResultService.mapToDto(surveyResult);

        URI uri = UriComponentsBuilder.fromUriString(PROTOCOL + "://" + HOST + ":" + PORT + PATH).build().toUri();
        ResponseEntity<RegionsResponse> response = restTemplate.postForEntity(uri, requestObject, RegionsResponse.class);

        if (response.getStatusCode().isError()) {
            throw new ServiceException("got http code" + response.getStatusCode(), serviceName);
        }

        if (response.getBody() == null) {
            throw new ServiceException("got empty body", serviceName);
        }

        List<Integer> regionIds = response.getBody().getRegions();

        if (regionIds == null) {
            throw new ServiceException("got null list", serviceName);
        }

        return getRegions(regionIds);
    }

    private List<Region> getRegions(List<Integer> regionIds) {
        List<Region> regions = new ArrayList<>();

        for (int id : regionIds) {
            Region region = regionRepository.findById((long) id)
                    .orElseThrow(() -> new ServiceException("no region with id " + id, serviceName));
            regions.add(region);
        }

        return regions;
    }
}
