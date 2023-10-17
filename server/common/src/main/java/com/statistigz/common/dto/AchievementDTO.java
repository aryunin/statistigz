package com.statistigz.common.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.statistigz.common.dto.serializer.ScoreSerializer;

public record AchievementDTO(
        ProjectionDTO projection,
        @JsonSerialize(using = ScoreSerializer.class)
        Double score
) { }
