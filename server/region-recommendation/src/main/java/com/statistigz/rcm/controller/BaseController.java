package com.statistigz.rcm.controller;

import com.statistigz.common.dto.classifier.ClassifierRegionsDTO;
import com.statistigz.common.dto.survey.OptionDTO;
import com.statistigz.common.dto.survey.SurveyDTO;
import com.statistigz.rcm.service.ClusterService;
import com.statistigz.rcm.exception.InvalidRequestException;
import com.statistigz.rcm.service.ClassifierService;
import com.statistigz.rcm.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public final class BaseController {
    private final CustomLogger logger;
    private final ClassifierService classifierService;
    private final ClusterService clusterService;

    @PostMapping
    Mono<ClassifierRegionsDTO> getRegionRecommendation(@RequestBody SurveyDTO surveyResult) {
        logger.debug(this, "getRegionRecommendation()");

        return getOptionsFromSurveyResult(surveyResult)
                .flatMap(classifierService::getClusterIdBySurveyResult)
                .flatMap(clusterService::getRegionsByClusterId);
    }

    private Mono<List<Integer>> getOptionsFromSurveyResult(SurveyDTO surveyResult) {
        return Flux.fromIterable(surveyResult.questions())
                .switchIfEmpty(
                    Mono.error(new InvalidRequestException("bad count of questions"))
                ).flatMapSequential(questionDTO -> {
                    List<Integer> options = questionDTO.options()
                            .stream()
                            .map(OptionDTO::orderIdx)
                            .toList();
                    return options.size() == 1 ? Flux.fromIterable(options) : Flux.error(
                            new InvalidRequestException("bad count of options on question with id " + questionDTO.id())
                    );
                }).collectList();
    }
}
