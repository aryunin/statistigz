package com.statistigz.main.service;

import com.statistigz.common.dto.RegionScoredDTO;

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
    List<RegionScoredDTO> normalize(List<RegionScoredDTO> regions);
}
