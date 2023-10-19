package com.statistigz.main.service.impl;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;
import com.statistigz.main.mapper.RegionDtoMapper;
import com.statistigz.main.repository.RegionProjectionRepository;
import com.statistigz.main.repository.RegionRepository;
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
    private final RegionProjectionRepository rpRepository;
    private final ScoreService scoreService;

    // Трюк для избежания декартова произведения, на самом деле регионы будут прогружены
    // только один раз, но их листы будут заполнены правильно. См. multiple-bag-fetch
    private List<Region> findAllJoin() {
        var withProjections = regionRepository.findAllJoinProjections();
        return !withProjections.isEmpty() ?
                regionRepository.findAllJoinAchievements() :
                withProjections;
    }

    @Override // TODO cacheable
    public List<RegionDTO> findAll() {
        var regions = findAllJoin();
        return regions.stream()
                .map(scoreService::calculate)
                .map(scoreService::scale)
                .map(RegionDtoMapper::mapToDto)
                .sorted(Comparator.comparing(RegionDTO::score).reversed())
                .toList();
    }

    @Override
    public List<RegionDTO> findAll(Projection projection) {
        var rps = rpRepository.findByProjection(projection);
        return rps.stream()
                .map(rp -> {
                    var score = rp.getScore();
                    var region = rp.getId().getRegion();
                    region.setScore(score);
                    scoreService.scale(region);
                    return RegionDtoMapper.mapToDto(region);
                })
                .sorted(Comparator.comparing(RegionDTO::score).reversed())
                .toList();
    }
}

