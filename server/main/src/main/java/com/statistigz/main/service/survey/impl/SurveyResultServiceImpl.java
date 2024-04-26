package com.statistigz.main.service.survey.impl;

import com.statistigz.common.dto.survey.AnswerDTO;
import com.statistigz.common.dto.survey.SurveyResultDTO;
import com.statistigz.main.entity.survey.*;
import com.statistigz.main.exception.ValidationException;
import com.statistigz.main.repository.survey.OptionRepository;
import com.statistigz.main.repository.survey.QuestionRepository;
import com.statistigz.main.repository.survey.SurveyRepository;
import com.statistigz.main.service.survey.SurveyResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurveyResultServiceImpl implements SurveyResultService {
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    private final SurveyRepository surveyRepository;

    @Override
    public SurveyResult resolveResult(SurveyResultDTO surveyResultDTO) {
        Survey survey = processSurvey(surveyResultDTO.surveyId());
        List<Answer> answers = processAnswers(survey, surveyResultDTO.answers());
        return new SurveyResult(survey, answers);
    }

    @Override
    public SurveyResultDTO mapToDto(SurveyResult surveyResult) {
        List<AnswerDTO> answers = surveyResult.getAnswers()
                .stream()
                .map(this::mapAnswerToDto)
                .toList();
        return new SurveyResultDTO(surveyResult.getSurvey().getId(), answers);
    }

    private Survey processSurvey(int surveyId) {
        return surveyRepository.getSurveyByIdFetchAll(surveyId)
                .orElseThrow(() -> new ValidationException("Survey with id " + surveyId + " not found"));
    }

    private List<Answer> processAnswers(Survey survey, List<AnswerDTO> answers) {
        return answers.stream()
                .map(dto -> processAnswer(survey, dto))
                .toList();
    }

    private Answer processAnswer(Survey survey, AnswerDTO answerDTO) {
        Question question = questionRepository.findBySurveyAndOrderIdx(survey, answerDTO.questionOrderIdx())
                .orElseThrow(() -> new ValidationException("Question with orderIdx " + answerDTO.questionOrderIdx() + " not found for survey with id " + survey.getId()));

        Option option = optionRepository.findByQuestionAndOrderIdx(question, answerDTO.optionOrderIdx())
                .orElseThrow(() -> new ValidationException("Option with orderIdx " + answerDTO.optionOrderIdx() + " not found for question with id " + question.getId()));

        return new Answer(question, option);
    }

    private AnswerDTO mapAnswerToDto(Answer answer) {
        return new AnswerDTO(answer.getQuestion().getOrderIdx(), answer.getOption().getOrderIdx());
    }
}
