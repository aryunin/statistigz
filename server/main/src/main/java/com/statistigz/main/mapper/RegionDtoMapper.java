package com.statistigz.main.mapper;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.common.dto.RegionProjectionDTO;
import com.statistigz.common.dto.RegionWithProjectionsDTO;
import com.statistigz.main.entity.Region;

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

    public static RegionWithProjectionsDTO mapToDtoWithProjections(Region region) {
        var projections = region.getRegionProjections()
                .stream()
                .map(rp -> {
                    var projection = ProjectionDtoMapper.mapToDto(rp.getId().getProjection());
                    var score = rp.getScore();
                    return new RegionProjectionDTO(projection, score);
                })
                .toList();

        var achievements = region.getAchievements().stream()
                .map(AchievementDtoMapper::mapToDTO)
                .toList();

        return new RegionWithProjectionsDTO(region.getId(), region.getName(), projections, achievements);
    }
}
