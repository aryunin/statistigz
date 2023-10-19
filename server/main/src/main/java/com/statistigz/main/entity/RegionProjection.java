package com.statistigz.main.entity;

import jakarta.persistence.*;
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
