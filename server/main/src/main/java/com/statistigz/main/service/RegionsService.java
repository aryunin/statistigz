package com.statistigz.main.service;

import com.statistigz.common.dto.region.RegionDTO;
import com.statistigz.common.dto.region.RegionScoreDTO;
import com.statistigz.common.dto.region.RegionProjectionsDTO;
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
    List<RegionScoreDTO> findAll(Projection projection);

    /**
     * @param id region's id
     * @return region with required id filled with projections
     */
    RegionProjectionsDTO findById(long id);

    /**
     * @param name region's name
     * @return regions with similar name
     */
    List<RegionDTO> findByName(String name);
}
