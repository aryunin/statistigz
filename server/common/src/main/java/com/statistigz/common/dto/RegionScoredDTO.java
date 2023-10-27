package com.statistigz.common.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.statistigz.common.dto.serializer.ScoreSerializer;

import java.util.List;

public record RegionScoredDTO(
        Long id,
        String name,
        @JsonSerialize(using = ScoreSerializer.class)
        Double score,
        List<AchievementDTO> achievements
) { }
