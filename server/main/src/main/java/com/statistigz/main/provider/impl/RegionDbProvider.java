package com.statistigz.main.provider.impl;

import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;
import com.statistigz.main.provider.RegionProvider;
import com.statistigz.main.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RegionDbProvider implements RegionProvider {
    private final RegionRepository regionRepository;

    @Override
    public Optional<Region> findByIdAndYear(long id, int year) {
        // using hibernate cache (see multiple bag fetch)
        var withAchievemnts = regionRepository.findByIdAndYearFetchAchievements(id, year);
        return regionRepository.findByIdAndYearFetchProjections(id, year);
    }

    @Override
    public List<Region> findByProjectionAndYear(Projection projection, int year) {
        // using hibernate cache (see multiple bag fetch)
        var regions = regionRepository.findAllByYearFetchAchievements(year);
        return !regions.isEmpty() ?
                regionRepository.findAllByProjectionAndYearFetchProjection(projection, year) :
                regions;
    }

    @Override
    public List<Region> search(String name) {
        return regionRepository.findByNameContainingIgnoreCase(name);
    }
}
