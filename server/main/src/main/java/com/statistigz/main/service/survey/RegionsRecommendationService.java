package com.statistigz.main.service.survey;

import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.survey.SurveyResult;

import java.util.List;

/**
 * @brief Сервис индивидуального подбора регионов. Стучится в классификатор.
 */
public interface RegionsRecommendationService {
    List<Region> processSurveyResult(SurveyResult surveyResult);
}
