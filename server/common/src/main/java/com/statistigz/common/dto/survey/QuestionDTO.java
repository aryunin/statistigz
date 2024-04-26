package com.statistigz.common.dto.survey;

import java.util.Set;

public record QuestionDTO(
    String text,
    int orderIdx,
    Set<OptionDTO> options
) { }
