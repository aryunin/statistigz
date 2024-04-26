package com.statistigz.main.service.survey.impl;

import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.survey.SurveyResult;
import com.statistigz.main.service.survey.RegionsRecommendationService;
import com.statistigz.main.service.survey.SurveyResultProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyResultProcessorImpl implements SurveyResultProcessor {
    private final RegionsRecommendationService regionsRecommendationService;

    @Override
    public List<Region> processRegionRecommendationSurveyResult(SurveyResult surveyResult) {
        return regionsRecommendationService.processSurveyResult(surveyResult);
    }
}
