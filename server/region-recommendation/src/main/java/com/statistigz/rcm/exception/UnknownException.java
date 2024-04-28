package com.statistigz.rcm.exception;

import com.statistigz.common.dto.ErrorResponse;

public class UnknownException extends RuntimeException implements CustomException {
    private static final int code = 3;

    public UnknownException(String message) {
        super(message);
    }

    @Override
    public ErrorResponse getResponse() {
        return new ErrorResponse(code, getMessage());
    }
}
