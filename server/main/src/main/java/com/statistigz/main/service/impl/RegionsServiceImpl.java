package com.statistigz.main.service.impl;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.entity.Projection;
import com.statistigz.main.mapper.RegionDtoMapper;
import com.statistigz.main.repository.RegionRepository;
import com.statistigz.main.service.AchievementsService;
import com.statistigz.main.service.RegionsService;
import com.statistigz.main.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
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
                .map(region -> RegionDtoMapper.mapToDto(
                        region,
                        scoreService.calculate(region),
                        achievementsService.calculate(region)
                ))
                .sorted(Comparator.comparing(RegionDTO::score).reversed())
                .toList(); // TODO N + 1 problem ???
    }

    @Override
    public List<RegionDTO> findAll(Projection projection) {
        var regions = regionRepository.findAll();
        return regions.stream()
                .map(region -> RegionDtoMapper.mapToDto(
                        region,
                        scoreService.calculate(region, projection),
                        achievementsService.calculate(region)
                ))
                .sorted(Comparator.comparing(RegionDTO::score).reversed())
                .toList();
    }
}

