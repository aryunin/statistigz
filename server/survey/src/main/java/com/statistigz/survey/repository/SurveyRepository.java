package com.statistigz.survey.repository;

import com.statistigz.survey.entity.Survey;
import reactor.core.publisher.Mono;

public interface SurveyRepository {
    Mono<Survey> findById(int id);
}
