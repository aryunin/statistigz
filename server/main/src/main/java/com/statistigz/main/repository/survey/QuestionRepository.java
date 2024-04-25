package com.statistigz.main.repository.survey;

import com.statistigz.main.entity.survey.Question;
import com.statistigz.main.entity.survey.Survey;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface QuestionRepository extends Repository<Question, Integer> {
    Optional<Question> findBySurveyAndOrderIdx(Survey survey, int orderIdx);
}
