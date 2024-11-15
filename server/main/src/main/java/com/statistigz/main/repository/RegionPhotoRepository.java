package com.statistigz.main.repository;

import com.statistigz.main.entity.RegionPhoto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RegionPhotoRepository extends PagingAndSortingRepository<RegionPhoto, Long> {
    Page<RegionPhoto> findByRegionId(long id, Pageable pageable);
}
