package com.statistigz.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Table(schema = "survey")
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Survey implements Serializable {
    @Serial
    private static final long serialVersionUID = 4439593511698069780L;

    @Id
    private int id;
    private String name;

    @Transient
    private List<Question> questions;
}
