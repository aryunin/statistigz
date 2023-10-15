package com.statistigz.main.repository;

import com.statistigz.main.entity.RegionCriteria;
import com.statistigz.main.entity.id.RegionCriteriaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionCriteriaRepository extends JpaRepository<RegionCriteria, RegionCriteriaId> {
}
