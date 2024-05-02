package com.statistigz.rcm.controller;

import com.statistigz.common.dto.classifier.ClassifierRegionsDTO;
import com.statistigz.common.dto.classifier.ClassifierSurveyDTO;
import com.statistigz.rcm.service.ClassifierService;
import com.statistigz.rcm.service.ClusterService;
import com.statistigz.rcm.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public final class BaseController {
    private final CustomLogger logger;
    private final ClassifierService classifierService;
    private final ClusterService clusterService;

    @PostMapping
    Mono<ClassifierRegionsDTO> getRegionRecommendation(@RequestBody ClassifierSurveyDTO surveyResult) {
        logger.debug(this, "getRegionRecommendation()");

        // TODO validate

        return classifierService.getClusterIdBySurveyResult(surveyResult.answers())
                .flatMap(clusterService::getRegionsByClusterId);
    }
}
