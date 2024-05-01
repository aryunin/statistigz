package com.statistigz.survey.mapper;

import com.statistigz.common.dto.survey.OptionDTO;
import com.statistigz.survey.entity.Option;
import com.statistigz.survey.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public final class OptionDtoMapper implements MonoMapper<Option, OptionDTO> {
    private final CustomLogger logger;

    @Override
    public Mono<OptionDTO> mapTo(Option option) {
        logger.debug(this, "mapTo()");
        logger.debug(this, "option = " + option);

        return Mono.just(new OptionDTO(option.getId(), option.getText(), option.getOrderIdx()));
    }

    @Override
    public Mono<Option> mapFrom(OptionDTO optionDto) {
        logger.debug(this, "mapFrom()");
        logger.debug(this, "optionDto = " + optionDto);

        return Mono.just(new Option(optionDto.id(), -1, optionDto.text(), optionDto.orderIdx()));
    }
}
