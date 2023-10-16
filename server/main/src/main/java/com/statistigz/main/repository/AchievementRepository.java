package com.statistigz.main.repository;

import com.statistigz.main.entity.Achievement;
import com.statistigz.main.entity.id.AchievementId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AchievementRepository extends Repository<Achievement, AchievementId> {

    @Query("""
            FROM Achievement ach
            JOIN FETCH Region r
            ON ach.id.region.id = r.id
            JOIN FETCH Projection p
            ON ach.id.projection.id = p.id
            WHERE r.id = :regionId
            """)
    List<Achievement> findByRegion(long regionId);
}
