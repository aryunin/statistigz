package com.statistigz.main.mapper.survey;

import com.statistigz.common.dto.survey.OptionDTO;
import com.statistigz.main.entity.survey.Option;
import com.statistigz.main.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public final class OptionDtoMapper implements Mapper<Option, OptionDTO> {
    @Override
    public OptionDTO mapTo(Option option) {
        return new OptionDTO(option.getText(), option.getOrderIdx());
    }

    @Override
    public Option mapFrom(OptionDTO optionDTO) {
        return null; // TODO implement if needed
    }
}
