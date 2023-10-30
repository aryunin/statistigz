package com.statistigz.common.dto.region;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.statistigz.common.dto.AchievementDTO;
import com.statistigz.common.dto.serializer.ScoreSerializer;

import java.util.List;

public record RegionScoreDTO(
        RegionDTO region,
        @JsonSerialize(using = ScoreSerializer.class)
        Double score,
        List<AchievementDTO> achievements
) { }
