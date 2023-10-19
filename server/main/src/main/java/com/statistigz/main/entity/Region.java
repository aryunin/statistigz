package com.statistigz.main.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "id.region")
    private List<RegionProjection> projections;
    @OneToMany(mappedBy = "id.region")
    private List<Achievement> achievements;
    @Transient
    private double score = 0;
}
