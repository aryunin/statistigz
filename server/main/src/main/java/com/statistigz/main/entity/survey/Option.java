package com.statistigz.main.entity.survey;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(schema = "survey")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class Option implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = -3761572988474409896L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private int orderIdx;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return id == option.id && orderIdx == option.orderIdx && Objects.equals(text, option.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, orderIdx);
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", orderIdx=" + orderIdx +
                '}';
    }
}
