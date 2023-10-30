package com.statistigz.common.dto.region;

import com.statistigz.common.dto.AchievementDTO;
import com.statistigz.common.dto.RegionProjectionDTO;

import java.util.List;

public record RegionProjectionsDTO(
    RegionDTO region,
    List<RegionProjectionDTO> projections,
    List<AchievementDTO> achievements
) {}
