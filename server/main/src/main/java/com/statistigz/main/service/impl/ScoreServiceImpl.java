package com.statistigz.main.service.impl;

import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.RegionProjection;
import com.statistigz.main.entity.id.RegionProjectionID;
import com.statistigz.main.repository.RegionProjectionRepository;
import com.statistigz.main.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScoreServiceImpl implements ScoreService {
    @Value("${constants.max-score}")
    private double MAX_SCORE;

    private final RegionProjectionRepository rpRepository;

    @Override
    @Cacheable(value = "score")
    public double calculate(Region region) {
        return rpRepository.findByRegion(region)
                .stream()
                .mapToDouble(RegionProjection::getScore)
                .average().orElse(0) * MAX_SCORE;
    }

    @Override
    @Cacheable(value = "score_projection")
    public double calculate(Region region, Projection projection) {
        var rp = rpRepository.findById(new RegionProjectionID(region, projection));
        return rp.map(regionProjection -> regionProjection.getScore() * MAX_SCORE).orElse(0.);
    }
}
