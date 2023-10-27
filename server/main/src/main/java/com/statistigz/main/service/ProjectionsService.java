package com.statistigz.main.service;

import com.statistigz.common.dto.projection.ProjectionCriteriaDTO;
import com.statistigz.main.entity.Projection;

import java.util.List;
import java.util.Optional;

/**
 * @brief service providing basic data about the projections and criteria inside
 */
public interface ProjectionsService {
    /**
     * @return all projections sorted by their name
     */
    List<ProjectionCriteriaDTO> findAll();

    /**
     * @param id id of the required projection
     * @return projection
     */
    Optional<Projection> findById(Long id);
}
