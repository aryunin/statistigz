package com.statistigz.main.service.impl;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;
import com.statistigz.main.mapper.RegionDtoMapper;
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
    private final ScoreService scoreService;

    // Трюк для избежания декартова произведения, на самом деле регионы будут прогружены
    // только один раз, но их листы будут заполнены правильно. См. multiple-bag-fetch
    private List<Region> findAllByYearFetch(int year) {
        // размер regions всегда будет равен количеству регионов, потому что LEFT JOIN по ачивкам
        // в то же время размер по проекциям может быть меньше, потому что INNER JOIN по проекциям
        // в таком случае мы не должны показывать регион, у которого нет данных по проекциям
        var regions = regionRepository.findAllByYearFetchAchievements(year);
        return !regions.isEmpty() ?
                regionRepository.findAllByYearFetchProjections(year) :
                regions;
    }

    // Трюк для избежания декартова произведения, на самом деле регионы будут прогружены
    // только один раз, но их листы будут заполнены правильно. См. multiple-bag-fetch
    private List<Region> findAllByProjectionAndYearFetch(Projection projection, int year) {
        // размер regions всегда будет равен количеству регионов, потому что LEFT JOIN по ачивкам
        // в то же время размер по проекциям может быть меньше, потому что INNER JOIN по проекциям
        // в таком случае мы не должны показывать регион, у которого нет данных по проекциям
        var regions = regionRepository.findAllByYearFetchAchievements(year);
        return !regions.isEmpty() ?
                regionRepository.findAllByProjectionAndYearFetchProjection(projection, year) :
                regions;
    }

    @Override // TODO cacheable
    public List<RegionDTO> findAll() {
        var year = 2020; // TODO
        var regions = findAllByYearFetch(year);
        var result = regions.stream()
                .map(scoreService::calculate)
                .map(scoreService::scale)
                .map(RegionDtoMapper::mapToDto)
                .sorted(Comparator.comparing(RegionDTO::score).reversed())
                .toList();
        return scoreService.renormalize(result);
    }

    @Override
    public List<RegionDTO> findAll(Projection projection) {
        var year = 2020; // TODO
        var regions = findAllByProjectionAndYearFetch(projection, year);
        return regions.stream()
                .peek(region -> {
                    var rpOpt = region.getRegionProjections().stream().findFirst();
                    var rp = rpOpt.orElseThrow(() ->
                            new RuntimeException(
                                    "No score for region " + region.getId() + " in projection " + projection.getId()
                            ) // такого случиться не должно
                    );
                    region.setScore(rp.getScore());
                })
                .map(scoreService::scale)
                .map(RegionDtoMapper::mapToDto)
                .sorted(Comparator.comparing(RegionDTO::score).reversed())
                .toList();
    }
}

