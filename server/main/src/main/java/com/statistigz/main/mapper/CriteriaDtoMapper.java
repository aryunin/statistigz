package com.statistigz.main.mapper;

import com.statistigz.common.dto.CriteriaDTO;
import com.statistigz.main.entity.Criteria;

public class CriteriaDtoMapper {
    public static CriteriaDTO mapToDto(Criteria criteria) {
        return new CriteriaDTO(criteria.getId(), criteria.getName());
    }
}
