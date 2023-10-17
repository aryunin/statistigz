package com.statistigz.main.repository;

import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.RegionProjection;
import com.statistigz.main.entity.id.RegionProjectionID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionProjectionRepository extends JpaRepository<RegionProjection, RegionProjectionID> {
    @Query("""
            FROM RegionProjection rp
            WHERE rp.id.region = :region
            """)
    List<RegionProjection> findByRegion(Region region);
}
