package com.statistigz.survey.repository;

import com.statistigz.survey.entity.Option;
import org.springframework.data.repository.Repository;
import reactor.core.publisher.Flux;

public interface OptionRepository extends Repository<Option, Integer> {
    Flux<Option> findByQuestionIdOrderByOrderIdxAsc(int questionId);
}
