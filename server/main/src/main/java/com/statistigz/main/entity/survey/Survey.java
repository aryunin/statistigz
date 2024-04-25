package com.statistigz.main.entity.survey;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(schema = "survey")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class Survey implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = 4439593511698069780L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "survey")
    private Set<Question> questions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        return id == survey.id && Objects.equals(name, survey.name) && Objects.equals(questions, survey.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, questions);
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                '}';
    }
}
