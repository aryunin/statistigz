package com.statistigz.main.repository;

import com.statistigz.main.entity.RegionPlace;
import com.statistigz.main.entity.RegionPlaceID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionPlaceRepository extends JpaRepository<RegionPlace, RegionPlaceID> {
}
