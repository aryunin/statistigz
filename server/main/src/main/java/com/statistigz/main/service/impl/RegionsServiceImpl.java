package com.statistigz.main.service.impl;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.entity.Region;
import com.statistigz.main.repository.RegionRepository;
import com.statistigz.main.service.AchievementsService;
import com.statistigz.main.service.RegionsService;
import com.statistigz.main.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionsServiceImpl implements RegionsService {
    private final RegionRepository regionRepository;
    private final ScoreService scoreService;
    private final AchievementsService achievementsService;

    @Override
    public List<RegionDTO> findAll() {
        var regions = regionRepository.findAll();
        return regions.stream()
                .map(this::mapToDto)
                .toList(); // TODO N + 1 problem ???
    }

    @Override
    public List<RegionDTO> findAll(Long projectionId) {
        var regions = regionRepository.findAll();
        return regions.stream()
                .map(r -> mapToDto(r, projectionId))
                .toList();
    }

    private RegionDTO mapToDto(Region region) {
        var id = region.getId();
        var score = scoreService.calculate(id);
        var achievements = achievementsService.calculate(id);
        return new RegionDTO(id, region.getName(), score, achievements);
    }

    private RegionDTO mapToDto(Region region, long projectionId) {
        var id = region.getId();
        var score = scoreService.calculate(id, projectionId);
        var achievements = achievementsService.calculate(id);
        return new RegionDTO(id, region.getName(), score, achievements);
    }

}

