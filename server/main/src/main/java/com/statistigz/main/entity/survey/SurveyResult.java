package com.statistigz.main.entity.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class SurveyResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 8385396541896883440L;

    private Survey survey;
    private List<Answer> answers;
}
