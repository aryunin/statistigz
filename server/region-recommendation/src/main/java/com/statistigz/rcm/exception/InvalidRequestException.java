package com.statistigz.rcm.exception;

import com.statistigz.common.dto.ErrorResponse;

public final class InvalidRequestException extends RuntimeException implements CustomException {
    private static final int code = 2;

    public InvalidRequestException(String message) {
        super(message);
    }

    @Override
    public ErrorResponse getResponse() {
        return new ErrorResponse(code, getMessage());
    }
}
