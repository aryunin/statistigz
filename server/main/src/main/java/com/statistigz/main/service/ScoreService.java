package com.statistigz.main.service;

import com.statistigz.main.entity.Region;

/**
 * @brief region score calculating service
 */
public interface ScoreService {
    /**
     * @brief calculates and sets region's score from its projections
     * @param region region
     * @return the same region
     */
    Region calculate(Region region);

    /**
     * @brief scales and sets the region's score (and achievements' score inside of it)
     * @param region region
     * @return the same region
     */
    Region scale(Region region);
}
