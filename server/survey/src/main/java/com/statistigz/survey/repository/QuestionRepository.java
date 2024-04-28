package com.statistigz.survey.repository;

import com.statistigz.survey.entity.Question;
import org.springframework.data.repository.Repository;
import reactor.core.publisher.Flux;

public interface QuestionRepository extends Repository<Question, Integer> {
    Flux<Question> findBySurveyIdOrderByOrderIdxAsc(int surveyId);
}
