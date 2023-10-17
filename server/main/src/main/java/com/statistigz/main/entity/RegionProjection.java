package com.statistigz.main.entity;

import com.statistigz.main.entity.id.RegionProjectionID;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@Immutable
public class RegionProjection {
    @EmbeddedId
    private RegionProjectionID id;
    private Double score;
}
