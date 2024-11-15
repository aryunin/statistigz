package com.statistigz.main.controller;

import com.statistigz.common.dto.region.RegionDTO;
import com.statistigz.common.dto.region.RegionPhotoDTO;
import com.statistigz.common.dto.region.RegionScoreDTO;
import com.statistigz.common.dto.region.RegionProjectionsDTO;
import com.statistigz.main.exception.InvalidRequestException;
import com.statistigz.main.exception.NotFoundException;
import com.statistigz.main.service.ProjectionsService;
import com.statistigz.main.service.RegionPhotoService;
import com.statistigz.main.service.RegionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionsController {
    private final RegionPhotoService regionPhotoService;
    private final RegionsService regionsService;
    private final ProjectionsService projectionsService;

    @Value("${constants.common-projection-id}")
    private Long COMMON_PROJECTION_ID;

    @GetMapping
    public Iterable<RegionScoreDTO> findAll(@RequestParam Optional<String> projectionId) {
        long parsedId;
        try {
            parsedId = projectionId.map(Long::parseLong).orElseGet(() -> COMMON_PROJECTION_ID);
        } catch (NumberFormatException ex) {
            throw new NotFoundException("Projection " + projectionId.get() + " not found");
        }

        var projection = projectionsService.findById(parsedId)
                .orElseThrow(() ->
                        new NotFoundException("Projection " + parsedId + " not found")
                );

        return regionsService.findAll(projection);
    }

    @GetMapping("/{id}")
    public RegionProjectionsDTO findById(@PathVariable Long id) {
        return regionsService.findById(id);
    }

    @GetMapping("/search")
    public Iterable<RegionDTO> findByName(@RequestParam Optional<String> name) {
        String sName = name.orElseThrow(
                () -> new InvalidRequestException("No text to search")
        );
        return regionsService.findByName(sName);
    }

    @GetMapping("/{id}/photo")
    public Iterable<RegionPhotoDTO> getPhoto(@PathVariable Long id,
                                             @RequestParam(defaultValue = "0") Integer offset,
                                             @RequestParam(defaultValue = "1") Integer limit) {
        return regionPhotoService.findPageById(id, offset, limit);
    }
}
