package com.statistigz.main.service.impl;

import com.statistigz.common.dto.ProjectionCriteriaDTO;
import com.statistigz.main.entity.Projection;
import com.statistigz.main.mapper.ProjectionDtoMapper;
import com.statistigz.main.repository.ProjectionRepository;
import com.statistigz.main.service.ProjectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectionsServiceImpl implements ProjectionsService {
    private final ProjectionRepository projectionRepository;

    @Override
    public List<ProjectionCriteriaDTO> findAll() {
        return projectionRepository.findAllJoin().stream()
                .map(ProjectionDtoMapper::mapToDto)
                .toList();
    }

    @Override
    public Optional<Projection> findById(Long id) {
        return projectionRepository.findById(id);
    }
}
