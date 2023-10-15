package com.statistigz.main.controller;

import com.statistigz.common.dto.ProjectionDTO;
import com.statistigz.main.service.ProjectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projections")
@RequiredArgsConstructor
public class ProjectionsController {
    private final ProjectionsService projectionsService;

    @GetMapping()
    public Iterable<ProjectionDTO> findAll() {
        return projectionsService.findAll();
    }
}
