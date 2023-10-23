package com.statistigz.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionProjectionID {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projection_id")
    private Projection projection;
    private Integer updateYear;
}
