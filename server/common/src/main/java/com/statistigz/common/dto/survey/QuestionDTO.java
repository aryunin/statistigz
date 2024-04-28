package com.statistigz.common.dto.survey;

import java.util.List;

public record QuestionDTO(
    int id,
    String text,
    int orderIdx,
    List<OptionDTO> options
) { }
