package com.statistigz.main.repository;

import com.statistigz.main.entity.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {
    @Query("FROM Projection p JOIN FETCH p.criteria c ORDER BY p.name ASC, c.name ASC")
    List<Projection> findAllJoin();
}
