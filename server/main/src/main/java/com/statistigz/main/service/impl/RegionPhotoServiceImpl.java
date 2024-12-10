package com.statistigz.main.service.impl;

import com.statistigz.common.dto.region.RegionPhotoDTO;
import com.statistigz.main.entity.RegionPhoto;
import com.statistigz.main.exception.NotFoundException;
import com.statistigz.main.mapper.RegionPhotoDtoMapper;
import com.statistigz.main.repository.RegionPhotoRepository;
import com.statistigz.main.repository.RegionRepository;
import com.statistigz.main.service.RegionPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionPhotoServiceImpl implements RegionPhotoService {
    private final RegionPhotoRepository regionPhotoRepository;
    private final RegionRepository regionRepository;

    @Override
    @Cacheable("photoPageByRegionId")
    public List<RegionPhotoDTO> findPageById(long id, int offset, int limit) {
        regionRepository.findById(id).orElseThrow(() -> new NotFoundException("No region with id " + id));
        Pageable pageable = PageRequest.of(offset, limit, Sort.by("id").ascending());
        Page<RegionPhoto> page = regionPhotoRepository.findByRegionId(id, pageable);
        return page.map(RegionPhotoDtoMapper::mapToDto).toList();
    }

    @Override
    @Cacheable("photoAllByRegionId")
    public List<RegionPhotoDTO> findAllById(Long id) {
        regionRepository.findById(id).orElseThrow(() -> new NotFoundException("No region with id " + id));
        return regionPhotoRepository.findByRegionIdOrderByIdAsc(id)
                .stream()
                .map(RegionPhotoDtoMapper::mapToDto)
                .toList();
    }
}
