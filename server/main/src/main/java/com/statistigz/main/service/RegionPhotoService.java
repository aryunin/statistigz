package com.statistigz.main.service;

import com.statistigz.common.dto.region.RegionPhotoDTO;

import java.util.List;

public interface RegionPhotoService {
    List<RegionPhotoDTO> findPageById(long id, int offset, int limit);

    List<RegionPhotoDTO> findAllById(Long id);
}
