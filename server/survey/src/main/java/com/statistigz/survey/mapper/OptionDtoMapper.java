package com.statistigz.survey.mapper;

import com.statistigz.common.dto.survey.OptionDTO;
import com.statistigz.common.util.Mapper;
import com.statistigz.survey.entity.Option;
import com.statistigz.survey.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// TODO reactive mapper ?

@Component
@RequiredArgsConstructor
public final class OptionDtoMapper implements Mapper<Option, OptionDTO> {
    private final CustomLogger logger;

    @Override
    public OptionDTO mapTo(Option option) {
        logger.debug(this, "mapTo()");
        logger.debug(this, "option = " + option);

        return new OptionDTO(option.getId(), option.getText(), option.getOrderIdx());
    }

    @Override
    public Option mapFrom(OptionDTO optionDto) {
        logger.debug(this, "mapFrom()");
        logger.debug(this, "optionDto = " + optionDto);

        return new Option(optionDto.id(), -1, optionDto.text(), optionDto.orderIdx());
    }
}
