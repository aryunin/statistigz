package com.statistigz.common.dto.projection;

import com.statistigz.common.dto.CriteriaDTO;

import java.util.List;

public record ProjectionCriteriaDTO(Long id, String name, List<CriteriaDTO> criteria) { }
