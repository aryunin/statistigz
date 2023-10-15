package com.statistigz.main.service.impl;

import com.statistigz.main.entity.RegionCriteria;
import com.statistigz.main.repository.RegionCriteriaRepository;
import com.statistigz.main.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScoreServiceImpl implements ScoreService {
    @Value("${constants.max-score}")
    private double MAX_SCORE;

    private final RegionCriteriaRepository rcRepository;

    @Override
    public double calculate(long regionId) {
        return 0;
    }

    @Override
    public double calculate(long regionId, long projectionId) {
        return rcRepository.findActualByRegionAndProjection(regionId, projectionId)
                .stream()
                .mapToDouble(RegionCriteria::getValue)
                .average().orElse(0.) * MAX_SCORE;
    }
}
