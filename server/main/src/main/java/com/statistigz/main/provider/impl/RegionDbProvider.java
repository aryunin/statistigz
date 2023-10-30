package com.statistigz.main.provider.impl;

import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.RegionPlaceID;
import com.statistigz.main.provider.RegionProvider;
import com.statistigz.main.repository.RegionPlaceRepository;
import com.statistigz.main.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RegionDbProvider implements RegionProvider {
    private final RegionRepository regionRepository;
    private final RegionPlaceRepository placeRepository;

    @Override
    public Optional<Region> findByIdAndYear(long id, int year) {
        // using hibernate cache (see multiple bag fetch)
        var withAchievemnts = regionRepository.findByIdAndYearFetchAchievements(id, year);
        var withProjections = regionRepository.findByIdAndYearFetchProjections(id, year);
        if (withProjections.isPresent()) {
            var region = withProjections.get();
            RegionPlaceID regionPlaceID = new RegionPlaceID(region, year);
            var regionPlace = placeRepository.findById(regionPlaceID).orElseThrow(
                    () -> new RuntimeException("No place for region " + region.getId())
            );
            region.setPlace(regionPlace.getPlace());
        }
        return withProjections;
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
