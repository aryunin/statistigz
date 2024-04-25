package com.statistigz.main.repository.survey;

import com.statistigz.main.entity.survey.Survey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface SurveyRepository extends Repository<Survey, Integer> {
    @Query("""
            FROM Survey s
            LEFT JOIN FETCH s.questions q
            LEFT JOIN FETCH q.options
            """)
    Optional<Survey> getSurveyByIdFetchAll(int id);
}
