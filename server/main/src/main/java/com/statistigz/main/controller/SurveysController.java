package com.statistigz.main.controller;

import com.statistigz.common.dto.region.RegionDTO;
import com.statistigz.common.dto.survey.SurveyDTO;
import com.statistigz.common.dto.survey.SurveyResultDTO;
import com.statistigz.main.entity.survey.Survey;
import com.statistigz.main.entity.survey.SurveyResult;
import com.statistigz.main.mapper.Mapper;
import com.statistigz.main.mapper.RegionDtoMapper;
import com.statistigz.main.service.survey.SurveyResultProcessor;
import com.statistigz.main.service.survey.SurveyResultService;
import com.statistigz.main.service.survey.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/surveys")
@RequiredArgsConstructor
public class SurveysController {
    private final SurveyService surveyService;
    private final Mapper<Survey, SurveyDTO> surveyDtoMapper;
    private final SurveyResultService surveyResultService;
    private final SurveyResultProcessor surveyResultProcessor;

    @GetMapping("/regionsRecommendation")
    public SurveyDTO getRegionsRecommendationSurvey() {
        Survey survey = surveyService.getSurveyById(SurveyService.REGIONS_RECOMMENDATION_SURVEY_ID);
        return surveyDtoMapper.mapTo(survey);
    }

    @PostMapping("/regionsRecommendation")
    public Iterable<RegionDTO> getRegionsRecommendation(@RequestBody SurveyResultDTO surveyResultDTO) {
        SurveyResult surveyResult = surveyResultService.resolveResult(surveyResultDTO);
        // TODO здесь можно валидировать наличие единого ответа на каждый вопрос, если нужно
        return surveyResultProcessor.processRegionRecommendationSurveyResult(surveyResult)
                .stream()
                .map(RegionDtoMapper::mapToDTO)
                .toList();
    }
}
