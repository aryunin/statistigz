package com.statistigz.survey.service;

import com.statistigz.survey.entity.Option;
import com.statistigz.survey.entity.Question;
import com.statistigz.survey.entity.Survey;
import com.statistigz.survey.exception.NotFoundException;
import com.statistigz.survey.repository.OptionRepository;
import com.statistigz.survey.repository.QuestionRepository;
import com.statistigz.survey.repository.SurveyRepository;
import com.statistigz.survey.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final CustomLogger logger;
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;

    @Override
    public Mono<Survey> getById(int id) {
        logger.debug(this, "getById()");
        logger.debug(this, "id = " + id);

        return surveyRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("survey " + id + " not found")))
                .flatMap(survey -> {
                    Flux<Question> questions = loadQuestions(survey);
                    return questions.flatMapSequential(question -> {
                        Flux<Option> options = loadOptions(question);
                        return options.collectList().map(optionsList -> {
                            question.setOptions(optionsList);
                            return question;
                        });
                    }).collectList().map(questionsList -> {
                        survey.setQuestions(questionsList);
                        return survey;
                    });
                });
    }

    private Flux<Question> loadQuestions(Survey survey) {
        logger.debug(this, "loadQuestions()");
        logger.debug(this, "survey = " + survey);

        return questionRepository.findBySurveyIdOrderByOrderIdxAsc(survey.getId());
    }

    private Flux<Option> loadOptions(Question question) {
        logger.debug(this, "loadOptions()");
        logger.debug(this, "question = " + question);

        return optionRepository.findByQuestionIdOrderByOrderIdxAsc(question.getId());
    }

}
