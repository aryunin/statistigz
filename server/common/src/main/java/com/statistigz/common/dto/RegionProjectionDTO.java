package com.statistigz.common.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.statistigz.common.dto.projection.ProjectionDTO;
import com.statistigz.common.dto.serializer.ScoreSerializer;

public record RegionProjectionDTO (
    ProjectionDTO projection,
    @JsonSerialize(using = ScoreSerializer.class)
    Double score
) {}
