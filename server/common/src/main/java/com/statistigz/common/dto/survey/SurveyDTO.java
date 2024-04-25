package com.statistigz.common.dto.survey;

import java.util.Set;

public record SurveyDTO(
    int id,
    String name,
    Set<QuestionDTO> questions
) { }
