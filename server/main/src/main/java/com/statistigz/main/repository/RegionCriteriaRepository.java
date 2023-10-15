package com.statistigz.main.repository;

import com.statistigz.main.entity.RegionCriteria;
import com.statistigz.main.entity.id.RegionCriteriaId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RegionCriteriaRepository extends Repository<RegionCriteria, RegionCriteriaId> {
    @Query("""
            FROM RegionCriteria rc\s
            WHERE rc.id.region.id = :regionId\s
            AND rc.id.criteria.id IN (
                SELECT cr.id FROM Projection pr\s
                JOIN Criteria cr ON cr.projection.id = pr.id\s
                WHERE pr.id = :projectionId
            )\s
            AND rc.id.updateDate = (
                SELECT MAX(id.updateDate)\s
                FROM RegionCriteria\s
                WHERE id.region.id = :regionId\s
                AND id.criteria.id = rc.id.criteria.id
            )
            """)
    List<RegionCriteria> findActualByRegionAndProjection(long regionId, long projectionId);
}
