package com.statistigz.main.mapper;

import com.statistigz.common.dto.AchievementDTO;
import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.entity.Region;

import java.util.List;

public class RegionDtoMapper {
    public static RegionDTO mapToDto(Region region, double score, List<AchievementDTO> achievements) {
        return new RegionDTO(region.getId(), region.getName(), score, achievements);
    }
}
