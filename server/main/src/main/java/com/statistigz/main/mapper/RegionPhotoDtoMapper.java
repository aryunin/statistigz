package com.statistigz.main.mapper;

import com.statistigz.common.dto.region.RegionPhotoDTO;
import com.statistigz.main.entity.RegionPhoto;

import java.util.Base64;

public class RegionPhotoDtoMapper {
    public static RegionPhotoDTO mapToDto(RegionPhoto regionPhoto) {
        String data = Base64.getEncoder().encodeToString(regionPhoto.getData());
        return new RegionPhotoDTO(regionPhoto.getId(), data);
    }
}
