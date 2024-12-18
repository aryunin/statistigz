package com.statistigz.cp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RegionPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
    private byte[] data;
}
