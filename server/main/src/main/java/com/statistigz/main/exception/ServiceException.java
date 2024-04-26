package com.statistigz.main.exception;

import com.statistigz.common.dto.ErrorResponse;

public class ServiceException extends RuntimeException implements CustomException {
    private static final int code = 4;

    private String serviceName;

    public ServiceException(String message, String serviceName) {
        super(message);
        this.serviceName = serviceName;
    }

    @Override
    public ErrorResponse getResponse() {
        return new ErrorResponse(code, "ERROR: " + getMessage() + " IN SERVICE: " + serviceName);
    }
}
