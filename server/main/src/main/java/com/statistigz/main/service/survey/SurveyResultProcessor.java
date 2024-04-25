package com.statistigz.main.service.survey;

import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.survey.SurveyResult;

import java.util.List;

/**
 * @brief Обработчик результатов опросов. В зависимости от метода, вызывает разные другие сервисы.
 */
public interface SurveyResultProcessor {
    List<Region> processRegionRecommendationSurveyResult(SurveyResult surveyResult);
}
