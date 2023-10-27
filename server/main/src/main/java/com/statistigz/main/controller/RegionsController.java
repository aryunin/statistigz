package com.statistigz.main.controller;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.common.dto.RegionWithProjectionsDTO;
import com.statistigz.main.exception.NotFoundException;
import com.statistigz.main.service.ProjectionsService;
import com.statistigz.main.service.RegionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionsController {
    private final RegionsService regionsService;
    private final ProjectionsService projectionsService;

    @GetMapping
    public Iterable<RegionDTO> findAll(@RequestParam Optional<String> projectionId) {
        final var commonProjectionId = 17;

        long parsedId;
        try {
            parsedId = projectionId.isEmpty() ? commonProjectionId : Long.parseLong(projectionId.get());
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
    public RegionWithProjectionsDTO findById(@PathVariable Long id) {
        return regionsService.findById(id);
    }
}
