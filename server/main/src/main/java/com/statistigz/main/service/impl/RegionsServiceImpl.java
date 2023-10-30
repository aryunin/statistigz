package com.statistigz.main.service.impl;

import com.statistigz.common.dto.region.RegionDTO;
import com.statistigz.common.dto.region.RegionProjectionsDTO;
import com.statistigz.common.dto.region.RegionScoreDTO;
import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.RegionProjection;
import com.statistigz.main.exception.NotFoundException;
import com.statistigz.main.mapper.RegionDtoMapper;
import com.statistigz.main.provider.RegionProvider;
import com.statistigz.main.provider.YearProvider;
import com.statistigz.main.service.RegionsService;
import com.statistigz.main.service.util.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionsServiceImpl implements RegionsService {
    private final RegionProvider regionProvider;
    private final YearProvider yearProvider;
    private final ScoreService scoreService;

    @Override
    @Cacheable("regionByProjection")
    public List<RegionScoreDTO> findAll(Projection projection) {
        var year = getActualYear();
        return regionProvider.findByProjectionAndYear(projection, year)
                .stream()
                .peek(this::setScoreFromFirstProjection)
                .map(RegionDtoMapper::mapToScoredDTO)
                .map(scoreService::scale)
                .sorted(Comparator.comparing(RegionScoreDTO::score).reversed())
                .toList();
    }

    @Override
    @Cacheable("regionById")
    public RegionProjectionsDTO findById(long id) {
        var year = getActualYear();
        var region = regionProvider.findByIdAndYear(id, year).orElseThrow(
                () -> new NotFoundException("Region with id " + id + " not found")
        );
        region.getRegionProjections().sort(Comparator.comparing(RegionProjection::getScore).reversed());
        var dto = RegionDtoMapper.mapToDtoWithProjections(region);
        return scoreService.scale(dto);
    }

    @Override
    @Cacheable("regionByName")
    public List<RegionDTO> findByName(String name) {
        return regionProvider.search(name)
                .stream()
                .map(RegionDtoMapper::mapToDTO)
                .sorted(Comparator.comparing(RegionDTO::name))
                .toList();
    }

    private void setScoreFromFirstProjection(Region region) {
        var rpOpt = region.getRegionProjections().stream().findFirst();
        var rp = rpOpt.orElseThrow(() ->
                new RuntimeException(
                        "No projections for region " + region.getId()
                ) // такого случиться не должно
        );
        region.setScore(rp.getScore());
    }

    private int getActualYear() {
        return yearProvider.getUpdateYears()
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("No data"));
    }
}

