package com.statistigz.rcm.service;

import com.statistigz.common.dto.classifier.ClassifierRegionsDTO;
import reactor.core.publisher.Mono;

public interface ClusterService {
    Mono<ClassifierRegionsDTO> getRegionsByClusterId(int clusterId);
}
