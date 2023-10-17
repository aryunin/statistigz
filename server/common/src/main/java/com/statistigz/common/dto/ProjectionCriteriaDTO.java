package com.statistigz.common.dto;

import java.util.List;

public record ProjectionCriteriaDTO(Long id, String name, List<CriteriaDTO> criteria) { }
