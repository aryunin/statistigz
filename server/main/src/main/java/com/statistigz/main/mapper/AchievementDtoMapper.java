package com.statistigz.main.mapper;

import com.statistigz.common.dto.AchievementDTO;
import com.statistigz.main.entity.Achievement;

public class AchievementDtoMapper {
    public static AchievementDTO mapToDTO(Achievement achievement) {
        return new AchievementDTO(
                ProjectionDtoMapper.mapToSimpleDto(achievement.getId().getProjection()),
                achievement.getScore()
        );
    }
}
