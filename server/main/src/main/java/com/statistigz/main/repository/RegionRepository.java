package com.statistigz.main.repository;

import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    @Query("""
            FROM Region r
            JOIN FETCH r.regionProjections rp
            WHERE rp.id.updateYear = :year
            """)
    List<Region> findAllByYearFetchProjections(int year);

    @Query("""
            FROM Region r
            LEFT JOIN FETCH r.achievements ach
            LEFT JOIN FETCH r.achievements.id.projection
            WHERE ach.id.updateYear = :year
            OR ach = null
            """)
    List<Region> findAllByYearFetchAchievements(int year);

    @Query("""
            FROM Region r
            JOIN FETCH r.regionProjections rp
            WHERE rp.id.updateYear = :year
            AND rp.id.projection = :projection
            """)
    List<Region> findAllByProjectionAndYearFetchProjection(Projection projection, int year);
}
