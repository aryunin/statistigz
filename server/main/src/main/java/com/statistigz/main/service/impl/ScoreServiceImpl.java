package com.statistigz.main.service.impl;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.RegionProjection;
import com.statistigz.main.service.ScoreService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ScoreServiceImpl implements ScoreService {
    @Value("${constants.max-score}")
    private double MAX_SCORE;

    @PostConstruct
    public void init() {
        if (MAX_SCORE < 2)
            throw new RuntimeException("Max score less than 2");
    }

    @Override
    public Region calculate(Region region) {
        var score = region.getRegionProjections().stream()
                .mapToDouble(RegionProjection::getScore)
                .average().orElse(0);
        region.setScore(score);
        return region;
    }

    @Override
    public Region scale(Region region) {
        var score = scale(region.getScore());
        region.setScore(score);
        region.getAchievements()
                .forEach(a -> {
                    var aScore = a.getScore();
                    a.setScore(scale(aScore));
                });
        return region;
    }

    @Override
    public List<RegionDTO> renormalize(List<RegionDTO> regions) {
        var max = regions.get(0).score();
        var min = regions.get(regions.size() - 1).score();
        var diff = max - min;
        return regions.stream()
                .map(region -> {
                    var score = region.score();
                    score = scale((score - min) / diff);
                    return new RegionDTO(region.id(), region.name(), score, region.achievements());
                })
                .toList();
    }

    private double scale(double score) {
        return 1 + score * (MAX_SCORE - 1);
    }
}
