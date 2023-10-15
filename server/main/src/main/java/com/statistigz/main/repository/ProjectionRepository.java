package com.statistigz.main.repository;

import com.statistigz.main.entity.Projection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProjectionRepository extends Repository<Projection, Long> {
    @Query("FROM Projection p JOIN FETCH p.criteria c")
    List<Projection> findAll();
}
