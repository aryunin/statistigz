package com.statistigz.main.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@Immutable
public class Achievement {
    @EmbeddedId
    private RegionProjectionID id;
    private Double score;
}
