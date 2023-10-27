package com.statistigz.main.service.impl;

import com.statistigz.common.dto.projection.ProjectionCriteriaDTO;
import com.statistigz.main.entity.Criteria;
import com.statistigz.main.entity.Projection;
import com.statistigz.main.mapper.ProjectionDtoMapper;
import com.statistigz.main.repository.ProjectionRepository;
import com.statistigz.main.service.ProjectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectionsServiceImpl implements ProjectionsService {
    private final ProjectionRepository projectionRepository;

    @Override
    @Cacheable("projections")
    public List<ProjectionCriteriaDTO> findAll() {
        return projectionRepository.findAllJoin().stream()
                .sorted(Comparator.comparing(Projection::getName))
                .peek(projection -> projection.getCriteria().sort(Comparator.comparing(Criteria::getName)))
                .map(ProjectionDtoMapper::mapToDtoWithCriteria)
                .toList();
    }

    @Override
    @Cacheable("projectionById")
    public Optional<Projection> findById(Long id) {
        return projectionRepository.findById(id);
    }
}
