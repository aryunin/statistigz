package com.statistigz.survey.exception;

import com.statistigz.common.dto.ErrorResponse;

public class MappingException extends RuntimeException implements CustomException {
    private static final int code = 2;

    public MappingException(String message) {
        super(message);
    }

    @Override
    public ErrorResponse getResponse() {
        return new ErrorResponse(code, getMessage());
    }
}