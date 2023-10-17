package com.statistigz.main.service;

import com.statistigz.common.dto.AchievementDTO;
import com.statistigz.main.entity.Region;

import java.util.List;

/**
 * @brief achievements service
 */
public interface AchievementsService {
    /**
     * @brief calculates all achievements of the region, works TOO SLOW
     * @param region region
     * @return region's achievements
     */
    List<AchievementDTO> calculate(Region region);
}
