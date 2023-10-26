package com.statistigz.main.mapper;

import com.statistigz.common.dto.AchievementDTO;
import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.entity.Region;

import java.util.Comparator;

public class RegionDtoMapper {
    public static RegionDTO mapToDto(Region region) {
        var achievements = region.getAchievements().stream()
                .map(AchievementDtoMapper::mapToDTO)
                .toList();

        return new RegionDTO(
                region.getId(),
                region.getName(),
                region.getScore(),
                achievements
        );
    }
}
