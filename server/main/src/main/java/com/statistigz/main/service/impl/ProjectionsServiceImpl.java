package com.statistigz.main.service.impl;

import com.statistigz.common.dto.CriteriaDTO;
import com.statistigz.common.dto.ProjectionDTO;
import com.statistigz.main.entity.Projection;
import com.statistigz.main.repository.ProjectionRepository;
import com.statistigz.main.service.ProjectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectionsServiceImpl implements ProjectionsService {
    private final ProjectionRepository projectionRepository;

    @Override
    public List<ProjectionDTO> findAll() {
        return projectionRepository.findAll().stream()
                .map(ProjectionsServiceImpl::mapToDto)
                .toList();
    }

    private static ProjectionDTO mapToDto(Projection projection) {
        var criteria = projection.getCriteria().stream()
                .map(c -> new CriteriaDTO(c.getId(), c.getName()))
                .toList();

        return new ProjectionDTO(projection.getId(), projection.getName(), criteria);
    }
}
