package com.statistigz.rcm.exception;

import com.statistigz.common.dto.ErrorResponse;

public final class NotFoundException extends RuntimeException implements CustomException {
    private static final int code = 1;

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorResponse getResponse() {
        return new ErrorResponse(code, getMessage());
    }
}
