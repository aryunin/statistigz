package com.statistigz.rcm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(schema = "region_recommendation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ClusterRegion {
    @Id
    private int id;
    private int clusterId;
    private long regionId;
}
