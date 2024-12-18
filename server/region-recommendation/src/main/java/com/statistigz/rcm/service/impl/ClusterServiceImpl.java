package com.statistigz.rcm.service.impl;

import com.statistigz.common.dto.classifier.ClassifierRegionsDTO;
import com.statistigz.rcm.service.ClusterService;
import com.statistigz.rcm.util.CustomLogger;
import com.statistigz.rcm.entity.ClusterRegion;
import com.statistigz.rcm.repository.ClusterRegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClusterServiceImpl implements ClusterService {
    private final CustomLogger logger;
    private final ClusterRegionRepository clusterRegionRepository;

    @Override
    public Mono<ClassifierRegionsDTO> getRegionsByClusterId(int clusterId) {
        logger.debug(this, "getRegionsByClusterId()");
        logger.debug(this, "clusterId = " + clusterId);

        return clusterRegionRepository.getByClusterId(clusterId)
                .map(ClusterRegion::getRegionId)
                .collectList()
                .map(ClassifierRegionsDTO::new);
    }
}
