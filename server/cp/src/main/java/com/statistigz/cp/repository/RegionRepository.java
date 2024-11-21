package com.statistigz.cp.repository;

import com.statistigz.cp.entity.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RegionRepository extends CrudRepository<Region, Long> {
    List<Region> findAllByOrderByNameAsc();

    @Query("FROM Region r LEFT JOIN FETCH r.photos p WHERE r.id = :id ORDER BY p.id ASC")
    Optional<Region> findByIdFetchPhotos(long id);
}
