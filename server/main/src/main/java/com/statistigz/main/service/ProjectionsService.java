package com.statistigz.main.service;

import com.statistigz.common.dto.ProjectionDTO;

import java.util.List;

/**
 * @brief service providing basic data about the projections and criteria inside
 */
public interface ProjectionsService {
    /**
     * @return all projections sorted by their name
     */
    List<ProjectionDTO> findAll();
}
