package com.statistigz.survey.repository;

import com.statistigz.survey.entity.Survey;
import org.springframework.data.repository.Repository;
import reactor.core.publisher.Mono;

public interface SurveyRepository extends Repository<Survey, Integer> {
    Mono<Survey> findById(int id);
}
