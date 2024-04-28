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
public final class Question implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = -8816400694548313359L;

    @Id
    private int id;
    private int surveyId;
    private String text;
    private int orderIdx;

    @Transient
    private List<Option> options;
}
