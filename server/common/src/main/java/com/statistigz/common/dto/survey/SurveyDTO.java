package com.statistigz.common.dto.survey;

import java.util.List;

public record SurveyDTO(
    int id,
    String name,
    List<QuestionDTO> questions
) { }
