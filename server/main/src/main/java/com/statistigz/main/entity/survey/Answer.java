package com.statistigz.main.entity.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Answer implements Serializable {
    @Serial
    private static final long serialVersionUID = -4430679517579829708L;

    private Question question;
    private Option option;
}
