package com.statistigz.main.service.impl;

import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.RegionProjection;
import com.statistigz.main.service.ScoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ScoreServiceImpl implements ScoreService {
    @Value("${constants.max-score}")
    private double MAX_SCORE;

    @Override
    public Region calculate(Region region) {
        var score = region.getProjections().stream()
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

    private double scale(double score) {
        return score * MAX_SCORE;
    }
}
