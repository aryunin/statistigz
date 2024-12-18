package com.statistigz.rcm.repository;

import com.statistigz.rcm.entity.ClusterRegion;
import org.springframework.data.repository.Repository;
import reactor.core.publisher.Flux;

public interface ClusterRegionRepository extends Repository<ClusterRegion, Integer> {
    Flux<ClusterRegion> getByClusterId(int clusterId);
}
