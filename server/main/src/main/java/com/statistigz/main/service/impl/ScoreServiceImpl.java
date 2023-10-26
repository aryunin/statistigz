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
    public List<RegionDTO> normalize(List<RegionDTO> regions) {
        if (regions.size() < 3)
            return regions.stream()
                    .map(r -> new RegionDTO(r.id(), r.name(), scale(r.score()), r.achievements()))
                    .toList();

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
