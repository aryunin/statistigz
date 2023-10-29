package com.statistigz.main.service;

import com.statistigz.common.dto.region.RegionProjectionsDTO;
import com.statistigz.common.dto.region.RegionScoreDTO;

/**
 * @brief region score calculating service
 */
public interface ScoreService {
    /**
     * @brief масштабирует score региона
     * @param region регион
     * @return тот же регион с масштабированным score
     */
    RegionScoreDTO scale(RegionScoreDTO region);

    /**
     * @brief масштабирует score региона
     * @param region регион
     * @return тот же регион с масштабированным score
     */
    RegionProjectionsDTO scale(RegionProjectionsDTO region);
}
