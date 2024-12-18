package com.statistigz.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;

@Table(schema = "survey")
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Option implements Serializable {
    @Serial
    private static final long serialVersionUID = -3761572988474409896L;

    @Id
    private int id;
    private int questionId;
    private String text;
    private int orderIdx;
}
