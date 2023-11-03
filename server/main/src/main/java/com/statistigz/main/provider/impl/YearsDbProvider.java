package com.statistigz.main.provider.impl;

import com.statistigz.main.provider.YearProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class YearsDbProvider implements YearProvider {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Integer> getUpdateYears() {
        var x =  entityManager.createQuery("""
                SELECT DISTINCT rp.id.updateYear
                FROM RegionProjection rp
                ORDER BY rp.id.updateYear DESC
                """).getResultList();
        return x.stream().mapToInt(o -> (int) o).boxed().toList();
    }
}
