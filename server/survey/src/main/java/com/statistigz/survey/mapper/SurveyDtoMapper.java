package com.statistigz.survey.mapper;

import com.statistigz.common.dto.survey.QuestionDTO;
import com.statistigz.common.dto.survey.SurveyDTO;
import com.statistigz.survey.entity.Question;
import com.statistigz.survey.entity.Survey;
import com.statistigz.survey.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public final class SurveyDtoMapper implements MonoMapper<Survey, SurveyDTO> {
    private final CustomLogger logger;
    private final MonoMapper<Question, QuestionDTO> questionDtoMapper;

    @Override
    public Mono<SurveyDTO> mapTo(Survey survey) {
        logger.debug(this, "mapTo()");
        logger.debug(this, "survey = " + survey);

        Flux<QuestionDTO> questions = Flux.fromIterable(survey.getQuestions())
                .flatMapSequential(questionDtoMapper::mapTo);

        return Mono.just(survey)
                .zipWith(questions.collectList())
                .map(tuple -> {
                    Survey t1 = tuple.getT1();
                    List<QuestionDTO> t2 = tuple.getT2();
                    logger.debug(this, "questionsDTOs = " + t2);
                    return new SurveyDTO(t1.getId(), t1.getName(), t2);
                });
    }

    @Override
    public Mono<Survey> mapFrom(SurveyDTO surveyDto) {
        logger.debug(this, "mapFrom()");
        logger.debug(this, "surveyDto = " + surveyDto);

        Flux<Question> questions = Flux.fromIterable(surveyDto.questions())
                .flatMapSequential(questionDtoMapper::mapFrom);

        return Mono.just(surveyDto)
                .zipWith(questions.collectList())
                .map(tuple -> {
                    SurveyDTO t1 = tuple.getT1();
                    List<Question> t2 = tuple.getT2();
                    logger.debug(this, "questions = " + t2);
                    return new Survey(t1.id(), t1.name(), t2);
                });
    }
}
