package com.statistigz.main.entity;

import com.statistigz.main.entity.id.RegionCriteriaId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Region_Criteria")
public class RegionCriteria {
    @EmbeddedId
    private RegionCriteriaId id;
    private Double value;
}
