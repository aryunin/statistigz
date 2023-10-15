package com.statistigz.common.dto;

import java.util.List;

public record ProjectionDTO(Long id, String name, List<CriteriaDTO> criteria) { }
