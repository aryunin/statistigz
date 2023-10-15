package com.statistigz.main.service;

import com.statistigz.common.dto.AchievementDTO;

import java.util.List;

public interface AchievementsService {
    List<AchievementDTO> calculate(long regionId);
}
