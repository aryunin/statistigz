package com.statistigz.main.service;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.common.dto.RegionScoredDTO;
import com.statistigz.common.dto.RegionWithProjectionsDTO;
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
    List<RegionScoredDTO> findAll(Projection projection);

    /**
     * @param id region's id
     * @return region with required id filled with projections
     */
    RegionWithProjectionsDTO findById(long id);

    /**
     * @param name region's name
     * @return regions with similar name
     */
    List<RegionDTO> findByName(String name);
}
