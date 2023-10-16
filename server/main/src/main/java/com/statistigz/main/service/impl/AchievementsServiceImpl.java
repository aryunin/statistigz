package com.statistigz.main.service.impl;

import com.statistigz.common.dto.AchievementDTO;
import com.statistigz.main.mapper.AchievementDtoMapper;
import com.statistigz.main.repository.AchievementRepository;
import com.statistigz.main.service.AchievementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AchievementsServiceImpl implements AchievementsService {
    @Value("${constants.max-score}")
    private double MAX_SCORE;

    private final AchievementRepository achievementRepository;

    @Override
    @Cacheable("achievement")
    public List<AchievementDTO> calculate(long regionId) {
        return achievementRepository.findByRegion(regionId)
                .stream()
                .map(AchievementDtoMapper::mapToDTO)
                .map(dto -> new AchievementDTO(
                        dto.projection(),
                        dto.score() * MAX_SCORE
                ))
                .toList();
    }
}
