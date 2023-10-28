package com.statistigz.main.mapper;

import com.statistigz.common.dto.AchievementDTO;
import com.statistigz.main.entity.Achievement;

public class AchievementDtoMapper {
    public static AchievementDTO mapToDTO(Achievement achievement) {
        var projection = ProjectionDtoMapper.mapToDto(achievement.getId().getProjection());
        return new AchievementDTO(projection);
    }
}
