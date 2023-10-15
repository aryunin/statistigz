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
    @ManyToOne
    @JoinColumn(name="projectionId")
    private Projection projection;
}
