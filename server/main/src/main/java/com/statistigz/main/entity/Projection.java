package com.statistigz.main.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "projection")
    private List<Criteria> criteria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projection that = (Projection) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
