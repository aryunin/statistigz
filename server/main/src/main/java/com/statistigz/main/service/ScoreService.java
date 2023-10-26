package com.statistigz.main.service;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.entity.Region;

import java.util.List;

/**
 * @brief region score calculating service
 */
public interface ScoreService {
    /**
     * @brief normalize regions score
     * @param regions regions
     * @return regions with normalized score
     */
    List<RegionDTO> normalize(List<RegionDTO> regions);
}
