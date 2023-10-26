package com.statistigz.main.service;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.entity.Projection;

import java.util.List;

/**
 * @brief service providing basic data about the regions
 */
public interface RegionsService {
    /**
     * @param projection projection
     * @return all regions in the required projection, sorted by score
     */
    List<RegionDTO> findAll(Projection projection);
}
