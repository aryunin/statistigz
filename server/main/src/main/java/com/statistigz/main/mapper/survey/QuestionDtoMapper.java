package com.statistigz.main.mapper.survey;

import com.statistigz.common.dto.survey.OptionDTO;
import com.statistigz.common.dto.survey.QuestionDTO;
import com.statistigz.main.entity.survey.Option;
import com.statistigz.main.entity.survey.Question;
import com.statistigz.main.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public final class QuestionDtoMapper implements Mapper<Question, QuestionDTO> {
    private final Mapper<Option, OptionDTO> optionDtoMapper;

    @Override
    public QuestionDTO mapTo(Question question) {
        Set<OptionDTO> options = question.getOptions()
                .stream()
                .map(optionDtoMapper::mapTo)
                .collect(Collectors.toSet());
        return new QuestionDTO(question.getText(), question.getOrderIdx(), options);
    }

    @Override
    public Question mapFrom(QuestionDTO questionDTO) {
        return null; // TODO implement if needed
    }
}
