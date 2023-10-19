package com.statistigz.main.repository;

import com.statistigz.main.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    @Query("""
            FROM Region r
            LEFT JOIN FETCH r.projections
            """)
    List<Region> findAllJoinProjections();

    @Query("""
            FROM Region r
            LEFT JOIN FETCH r.achievements
            LEFT JOIN FETCH r.achievements.id.projection
            """)
    List<Region> findAllJoinAchievements();
}
