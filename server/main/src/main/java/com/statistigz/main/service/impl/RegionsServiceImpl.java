package com.statistigz.main.service.impl;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.common.dto.RegionScoredDTO;
import com.statistigz.common.dto.RegionWithProjectionsDTO;
import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;
import com.statistigz.main.exception.NotFoundException;
import com.statistigz.main.mapper.RegionDtoMapper;
import com.statistigz.main.repository.RegionRepository;
import com.statistigz.main.service.RegionsService;
import com.statistigz.main.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionsServiceImpl implements RegionsService {
    private final RegionRepository regionRepository;
    private final ScoreService scoreService;

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

    private Optional<Region> findByIdAndYearFetch(long id, int year) {
        var withAchievemnts = regionRepository.findByIdAndYearFetchAchievements(id, year);
        return regionRepository.findByIdAndYearFetchProjections(id, year);
    }

    @Override // TODO cacheable
    public List<RegionScoredDTO> findAll(Projection projection) {
        var year = 2020; // TODO
        var regions = findAllByProjectionAndYearFetch(projection, year);
        return regions.stream()
                .peek(this::setScoreFromFirstProjection)
                .map(RegionDtoMapper::mapToScoredDTO)
                .sorted(Comparator.comparing(RegionScoredDTO::score).reversed())
                .toList();
    }

    @Override // TODO cacheable
    public RegionWithProjectionsDTO findById(long id) {
        var year = 2020; // TODO
        var region = findByIdAndYearFetch(id, year).orElseThrow(
                () -> new NotFoundException("Region with id " + id + " not found")
        );
        return RegionDtoMapper.mapToDtoWithProjections(region);
    }

    @Override // TODO cacheable
    public List<RegionDTO> findByName(String name) {
        return regionRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(RegionDtoMapper::mapToDTO)
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
}

