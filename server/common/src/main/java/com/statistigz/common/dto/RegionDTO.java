package com.statistigz.common.dto;

import java.util.List;

public record RegionDTO(Long id, String name, Double score, List<AchievementDTO> achievements) { }
