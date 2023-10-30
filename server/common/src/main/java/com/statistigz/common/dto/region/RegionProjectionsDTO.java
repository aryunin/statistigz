package com.statistigz.common.dto.region;

import com.statistigz.common.dto.AchievementDTO;
import com.statistigz.common.dto.RegionProjectionDTO;

import java.util.List;

public record RegionProjectionsDTO(
    RegionDTO region,
    Integer place,
    List<RegionProjectionDTO> projections,
    List<AchievementDTO> achievements
) {}
