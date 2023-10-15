package com.statistigz.main.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="projectionid")
    private Projection projection;
}
