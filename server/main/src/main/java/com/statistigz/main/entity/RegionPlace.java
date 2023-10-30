package com.statistigz.main.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@Immutable
public class RegionPlace {
    @EmbeddedId
    private RegionPlaceID id;
    private Integer place;
}
