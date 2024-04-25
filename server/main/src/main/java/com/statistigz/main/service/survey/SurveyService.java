package com.statistigz.main.service.survey;

import com.statistigz.main.entity.survey.Survey;

/**
 * @brief Сервис опросов. Не работает с результатами. Работает с самими опросами
 */
public interface SurveyService {
    int REGIONS_RECOMMENDATION_SURVEY_ID = 1; // ID анкеты индивидуального подбора регионов

    Survey getSurveyById(int id);
}
