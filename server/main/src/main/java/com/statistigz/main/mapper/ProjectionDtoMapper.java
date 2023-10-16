package com.statistigz.main.mapper;

import com.statistigz.common.dto.ProjectionDTO;
import com.statistigz.common.dto.ProjectionSimpleDTO;
import com.statistigz.main.entity.Projection;

public class ProjectionDtoMapper {
    public static ProjectionDTO mapToDto(Projection projection) {
        var criteria = projection.getCriteria().stream()
                .map(CriteriaDtoMapper::mapToDto)
                .toList();

        return new ProjectionDTO(projection.getId(), projection.getName(), criteria);
    }

    public static ProjectionSimpleDTO mapToSimpleDto(Projection projection) {
        return new ProjectionSimpleDTO(projection.getId(), projection.getName());
    }
}
