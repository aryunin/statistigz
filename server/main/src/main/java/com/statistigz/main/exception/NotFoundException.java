package com.statistigz.main.exception;

import com.statistigz.common.dto.ErrorResponse;

public class NotFoundException extends RuntimeException implements CustomException {
    private static final int code = 1;

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorResponse getResponse() {
        return new ErrorResponse(code, getMessage());
    }
}
