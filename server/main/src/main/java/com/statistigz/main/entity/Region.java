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
    private List<RegionProjection> regionProjections;
    @OneToMany(mappedBy = "id.region")
    private List<Achievement> achievements;
    @OneToMany(mappedBy = "region")
    private List<RegionPhoto> photos;
    @Transient
    private double score = 0;
}
