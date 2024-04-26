package com.statistigz.main.exception;

import com.statistigz.common.dto.ErrorResponse;

public class ValidationException extends RuntimeException implements CustomException {
    private static final int code = 3;

    public ValidationException(String message) {
        super(message);
    }

    @Override
    public ErrorResponse getResponse() {
        return new ErrorResponse(code, getMessage());
    }
}
