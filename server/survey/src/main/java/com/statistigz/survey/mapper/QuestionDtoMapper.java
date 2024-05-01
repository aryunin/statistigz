package com.statistigz.survey.mapper;

import com.statistigz.common.dto.survey.OptionDTO;
import com.statistigz.common.dto.survey.QuestionDTO;
import com.statistigz.survey.entity.Option;
import com.statistigz.survey.entity.Question;
import com.statistigz.survey.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public final class QuestionDtoMapper implements MonoMapper<Question, QuestionDTO> {
    private final CustomLogger logger;
    private final MonoMapper<Option, OptionDTO> optionDtoMapper;

    @Override
    public Mono<QuestionDTO> mapTo(Question question) {
        logger.debug(this, "mapTo()");
        logger.debug(this, "question = " + question);

        Flux<OptionDTO> options = Flux.fromIterable(question.getOptions())
                .flatMapSequential(optionDtoMapper::mapTo);

        return Mono.just(question)
                .zipWith(options.collectList())
                .map(tuple -> {
                    Question t1 = tuple.getT1();
                    List<OptionDTO> t2 = tuple.getT2();
                    logger.debug(this, "optionDTOs = " + t2);
                    return new QuestionDTO(t1.getId(), t1.getText(), t1.getOrderIdx(), t2);
                });
    }

    @Override
    public Mono<Question> mapFrom(QuestionDTO questionDto) {
        logger.debug(this, "mapFrom()");
        logger.debug(this, "questionDto = " + questionDto);

        Flux<Option> options = Flux.fromIterable(questionDto.options())
                .flatMapSequential(optionDtoMapper::mapFrom);

        return Mono.just(questionDto)
                .zipWith(options.collectList())
                .map(tuple -> {
                    QuestionDTO t1 = tuple.getT1();
                    List<Option> t2 = tuple.getT2();
                    logger.debug(this, "options = " + t2);
                    return new Question(t1.id(), -1, t1.text(), t1.orderIdx(), t2);
                });
    }
}
