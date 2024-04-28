package com.statistigz.survey.service;

import com.statistigz.survey.entity.Survey;
import com.statistigz.survey.repository.SurveyRepository;
import com.statistigz.survey.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final CustomLogger logger;
    private final SurveyRepository surveyRepository;

    @Override
    public Mono<Survey> getById(int id) {
        logger.debug(this, "getById()");
        logger.debug(this, "id = " + id);

        return surveyRepository.findById(id);
    }
}
