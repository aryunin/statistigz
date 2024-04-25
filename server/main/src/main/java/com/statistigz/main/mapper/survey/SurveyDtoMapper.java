package com.statistigz.main.mapper.survey;

import com.statistigz.common.dto.survey.QuestionDTO;
import com.statistigz.common.dto.survey.SurveyDTO;
import com.statistigz.main.entity.survey.Question;
import com.statistigz.main.entity.survey.Survey;
import com.statistigz.main.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public final class SurveyDtoMapper implements Mapper<Survey, SurveyDTO> {
    private final Mapper<Question, QuestionDTO> questionDtoMapper;

    @Override
    public SurveyDTO mapTo(Survey survey) {
        Set<QuestionDTO> questions = survey.getQuestions()
                .stream()
                .map(questionDtoMapper::mapTo)
                .collect(Collectors.toSet());
        return new SurveyDTO(survey.getId(), survey.getName(), questions);
    }

    @Override
    public Survey mapFrom(SurveyDTO surveyDTO) {
        Set<Question> questions = surveyDTO.questions()
                .stream()
                .map(questionDtoMapper::mapFrom)
                .collect(Collectors.toSet());
        return new Survey(surveyDTO.id(), surveyDTO.name(), questions);
    }
}
