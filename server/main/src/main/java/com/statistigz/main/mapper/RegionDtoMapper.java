package com.statistigz.main.mapper;

import com.statistigz.common.dto.region.RegionDTO;
import com.statistigz.common.dto.region.RegionProjectionsDTO;
import com.statistigz.common.dto.region.RegionScoreDTO;
import com.statistigz.main.entity.Region;

public class RegionDtoMapper {
    public static RegionDTO mapToDTO(Region region) {
        return new RegionDTO(region.getId(), region.getName(), region.getDescription());
    }

    public static RegionScoreDTO mapToScoredDTO(Region region) {
        var achievements = region.getAchievements().stream()
                .map(AchievementDtoMapper::mapToDTO)
                .toList();

        return new RegionScoreDTO(
                region.getId(),
                region.getName(),
                region.getScore(),
                achievements
        );
    }

    public static RegionProjectionsDTO mapToDtoWithProjections(Region region) {
        var projections = region.getRegionProjections()
                .stream()
                .map(RegionProjectionDtoMapper::mapToDTO)
                .toList();

        var achievements = region.getAchievements().stream()
                .map(AchievementDtoMapper::mapToDTO)
                .toList();

        return new RegionProjectionsDTO(
                region.getId(),
                region.getName(),
                region.getDescription(),
                projections,
                achievements
        );
    }
}
