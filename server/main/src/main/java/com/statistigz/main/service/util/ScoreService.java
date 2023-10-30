package com.statistigz.main.service.util;

import com.statistigz.common.dto.RegionProjectionDTO;
import com.statistigz.common.dto.region.RegionProjectionsDTO;
import com.statistigz.common.dto.region.RegionScoreDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ScoreService {
    @Value("${constants.max-score}")
    private double MAX_SCORE;

    @PostConstruct
    public void init() {
        if (MAX_SCORE < 2)
            throw new RuntimeException("Max score less than 2");
    }

    public RegionScoreDTO scale(RegionScoreDTO region) {
        var score = scale(region.score());
        return new RegionScoreDTO(region.region(), score, region.achievements());
    }

    public RegionProjectionsDTO scale(RegionProjectionsDTO region) {
        var rps = region.projections()
                .stream()
                .map((rp) -> {
                    var score = scale(rp.score());
                    return new RegionProjectionDTO(rp.projection(), score);
                })
                .toList();
        return new RegionProjectionsDTO(region.region(), rps, region.achievements());
    }

    private double scale(double score) {
        return 1 + score * (MAX_SCORE - 1);
    }
}
