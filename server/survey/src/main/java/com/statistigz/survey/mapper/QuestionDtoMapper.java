package com.statistigz.survey.mapper;

import com.statistigz.common.dto.survey.OptionDTO;
import com.statistigz.common.dto.survey.QuestionDTO;
import com.statistigz.common.util.Mapper;
import com.statistigz.survey.entity.Option;
import com.statistigz.survey.entity.Question;
import com.statistigz.survey.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

// TODO reactive mapper ?

@Component
@RequiredArgsConstructor
public final class QuestionDtoMapper implements Mapper<Question, QuestionDTO> {
    private final CustomLogger logger;
    private final Mapper<Option, OptionDTO> optionDtoMapper;

    @Override
    public QuestionDTO mapTo(Question question) {
        logger.debug(this, "mapTo()");
        logger.debug(this, "question = " + question);

        List<OptionDTO> options = question.getOptions()
                .stream()
                .map(optionDtoMapper::mapTo)
                .toList();

        logger.debug(this, "optionDTOs = " + options);

        return new QuestionDTO(question.getId(), question.getText(), question.getOrderIdx(), options);
    }

    @Override
    public Question mapFrom(QuestionDTO questionDto) {
        logger.debug(this, "mapFrom()");
        logger.debug(this, "questionDto = " + questionDto);

        List<Option> options = questionDto.options()
                .stream()
                .map(optionDtoMapper::mapFrom)
                .toList();

        logger.debug(this, "options = " + options);

        return new Question(questionDto.id(), -1, questionDto.text(), questionDto.orderIdx(), options);
    }
}
