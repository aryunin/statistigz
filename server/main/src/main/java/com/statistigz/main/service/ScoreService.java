package com.statistigz.main.service;

import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;

/**
 * @brief region score calculating service
 */
public interface ScoreService {
    /**
     * @brief calculates region's score
     * @param region region
     * @return score
     */
    double calculate(Region region);

    /**
     * @brief calculates region's score for the projection
     * @param region region
     * @param projection projection
     * @return score
     */
    double calculate(Region region, Projection projection);
}
