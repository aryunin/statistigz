package com.statistigz.main.mapper;

import com.statistigz.common.dto.projection.ProjectionCriteriaDTO;
import com.statistigz.common.dto.projection.ProjectionDTO;
import com.statistigz.main.entity.Projection;

public class ProjectionDtoMapper {
    public static ProjectionCriteriaDTO mapToDtoWithCriteria(Projection projection) {
        var criteria = projection.getCriteria().stream()
                .map(CriteriaDtoMapper::mapToDto)
                .toList();
        return new ProjectionCriteriaDTO(projection.getId(), projection.getName(), criteria);
    }

    public static ProjectionDTO mapToDto(Projection projection) {
        return new ProjectionDTO(projection.getId(), projection.getName());
    }
}
