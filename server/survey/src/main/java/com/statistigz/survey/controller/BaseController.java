package com.statistigz.survey.controller;

import com.statistigz.common.dto.survey.SurveyDTO;
import com.statistigz.common.util.Mapper;
import com.statistigz.survey.entity.Survey;
import com.statistigz.survey.service.SurveyService;
import com.statistigz.survey.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public final class BaseController {
    private final CustomLogger logger;
    private final SurveyService surveyService;
    private final Mapper<Survey, SurveyDTO> surveyDtoMapper;

    @GetMapping
    Mono<SurveyDTO> getRegionRecommendationSurvey() {
        logger.debug(this, "getRegionRecommendationSurvey()");
        return surveyService
                .getById(SurveyService.REGION_RECOMMENDATION)
                .map(surveyDtoMapper::mapTo);
    }
}
