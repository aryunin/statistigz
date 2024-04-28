package com.statistigz.survey.mapper;

import com.statistigz.common.dto.survey.QuestionDTO;
import com.statistigz.common.dto.survey.SurveyDTO;
import com.statistigz.common.util.Mapper;
import com.statistigz.survey.entity.Question;
import com.statistigz.survey.entity.Survey;
import com.statistigz.survey.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

// TODO reactive mapper ?

@Component
@RequiredArgsConstructor
public final class SurveyDtoMapper implements Mapper<Survey, SurveyDTO> {
    private final CustomLogger logger;
    private final Mapper<Question, QuestionDTO> questionDtoMapper;

    @Override
    public SurveyDTO mapTo(Survey survey) {
        logger.debug(this, "mapTo()");
        logger.debug(this, "survey = " + survey);

        List<QuestionDTO> questions = survey.getQuestions()
                .stream()
                .map(questionDtoMapper::mapTo)
                .toList();

        logger.debug(this, "questionDTOs = " + questions);

        return new SurveyDTO(survey.getId(), survey.getName(), questions);
    }

    @Override
    public Survey mapFrom(SurveyDTO surveyDto) {
        logger.debug(this, "mapFrom()");
        logger.debug(this, "surveyDto = " + surveyDto);

        List<Question> questions = surveyDto.questions()
                .stream()
                .map(questionDtoMapper::mapFrom)
                .toList();

        logger.debug(this, "questions = " + questions);

        return new Survey(surveyDto.id(), surveyDto.name(), questions);
    }
}
