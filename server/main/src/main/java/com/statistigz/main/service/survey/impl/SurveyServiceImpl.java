package com.statistigz.main.service.survey.impl;

import com.statistigz.main.entity.survey.Survey;
import com.statistigz.main.exception.NotFoundException;
import com.statistigz.main.repository.survey.SurveyRepository;
import com.statistigz.main.service.survey.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;

    @Override
    public Survey getSurveyById(int id) {
        return surveyRepository.getSurveyByIdFetchAll(id)
                .orElseThrow(()->new NotFoundException("Survey with id " + id + " not found"));
    }
}
