package com.statistigz.main.repository;

import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.RegionProjection;
import com.statistigz.main.entity.RegionProjectionID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionProjectionRepository extends JpaRepository<RegionProjection, RegionProjectionID> {
    @Query("""
            FROM RegionProjection rp
            JOIN FETCH rp.id.region
            LEFT JOIN FETCH rp.id.region.achievements
            LEFT JOIN FETCH rp.id.region.achievements.id.projection
            WHERE rp.id.projection = :projection
            """)
    List<RegionProjection> findByProjection(Projection projection);
}
