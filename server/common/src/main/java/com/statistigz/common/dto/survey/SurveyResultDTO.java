package com.statistigz.common.dto.survey;

import java.util.List;

public record SurveyResultDTO(
    int surveyId,
    List<AnswerDTO> answers
) { }
