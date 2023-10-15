package com.statistigz.main.service.impl;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.repository.RegionRepository;
import com.statistigz.main.service.RegionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionsServiceImpl implements RegionsService {
    private final RegionRepository regionRepository;

    @Override
    public List<RegionDTO> findAll() {
        return null;
    }

    @Override
    public List<RegionDTO> findAll(Long projectionId) {
        return null;
    }
}

