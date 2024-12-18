package com.statistigz.main.repository;

import com.statistigz.main.entity.RegionPhoto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionPhotoRepository extends JpaRepository<RegionPhoto, Long> {
   Page<RegionPhoto> findByRegionId(long id, Pageable pageable);
   List<RegionPhoto> findByRegionIdOrderByIdAsc(long id);
}
