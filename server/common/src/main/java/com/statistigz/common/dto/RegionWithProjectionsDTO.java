package com.statistigz.common.dto;

import java.util.List;

public record RegionWithProjectionsDTO (
    Long id,
    String name,
    List<RegionProjectionDTO> projections,
    List<AchievementDTO> achievements
) {}
