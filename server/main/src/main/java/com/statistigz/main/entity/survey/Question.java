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
public final class Question implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = -8816400694548313359L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private int orderIdx;
    @OneToMany(mappedBy = "question")
    private Set<Option> options;
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id && orderIdx == question.orderIdx && Objects.equals(text, question.text) && Objects.equals(options, question.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, orderIdx, options);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", orderIdx=" + orderIdx +
                ", options=" + options +
                '}';
    }
}
