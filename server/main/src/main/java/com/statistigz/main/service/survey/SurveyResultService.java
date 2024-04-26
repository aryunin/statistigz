package com.statistigz.main.service.survey;

import com.statistigz.common.dto.survey.SurveyResultDTO;
import com.statistigz.main.entity.survey.SurveyResult;

/**
 * @brief Сервис результатов опросов.
 */
public interface SurveyResultService {
    SurveyResult resolveResult(SurveyResultDTO surveyResultDTO);
    SurveyResultDTO mapToDto(SurveyResult surveyResult);
}
