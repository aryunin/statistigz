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
    @JoinColumn(name="projection_id")
    private Projection projection;
}
