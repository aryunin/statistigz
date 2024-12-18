package com.statistigz.main.mapper;

import com.statistigz.common.dto.RegionProjectionDTO;
import com.statistigz.main.entity.RegionProjection;

public class RegionProjectionDtoMapper {
    public static RegionProjectionDTO mapToDTO(RegionProjection rp) {
        var projectionDto = ProjectionDtoMapper.mapToDto(rp.getId().getProjection());
        return new RegionProjectionDTO(projectionDto, rp.getScore(), rp.getPlace());
    }
}
