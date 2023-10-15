package com.statistigz.main.controller;

import com.statistigz.common.dto.RegionDTO;
import com.statistigz.main.exception.NotFoundException;
import com.statistigz.main.service.RegionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionsController {
    private final RegionsService regionsService;

    @GetMapping
    public Iterable<RegionDTO> findAll(@RequestParam Optional<String> projectionId) {
        if (projectionId.isEmpty()) {
            return regionsService.findAll();
        }
        else {
            try {
              Long id = Long.parseLong(projectionId.get());
              return regionsService.findAll(id);
            }
            catch (NumberFormatException ex) {
                throw new NotFoundException("Projection " + projectionId.get() + " not found");
            }
        }
    }
}
