package com.statistigz.main.repository.survey;

import com.statistigz.main.entity.survey.Option;
import com.statistigz.main.entity.survey.Question;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface OptionRepository extends Repository<Option, Integer> {
    Optional<Option> findByQuestionAndOrderIdx(Question question, int orderIdx);
}
