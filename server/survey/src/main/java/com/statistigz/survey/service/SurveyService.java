package com.statistigz.survey.service;

import com.statistigz.survey.entity.Survey;
import reactor.core.publisher.Mono;

/**
 * @brief Сервис опросов.
 */
public interface SurveyService {
    int REGION_RECOMMENDATION = 1;

    Mono<Survey> getById(int id);
}
