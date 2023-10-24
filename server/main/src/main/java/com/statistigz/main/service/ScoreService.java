package com.statistigz.main.service;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.entity.Region;

import java.util.List;

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

    /**
     * @brief normalize regions score
     * @param regions regions
     * @return regions with normalized score
     */
    List<RegionDTO> renormalize(List<RegionDTO> regions);
}
