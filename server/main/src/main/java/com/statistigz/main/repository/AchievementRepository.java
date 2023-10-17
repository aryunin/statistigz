package com.statistigz.main.repository;

import com.statistigz.main.entity.Achievement;
import com.statistigz.main.entity.Region;
import com.statistigz.main.entity.id.AchievementID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, AchievementID> {
    @Query("""
            FROM Achievement ach
            WHERE ach.id.region = :region
            """)
    List<Achievement> findByRegion(Region region);

}
