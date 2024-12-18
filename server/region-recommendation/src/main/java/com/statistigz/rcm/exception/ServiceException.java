package com.statistigz.rcm.exception;

import com.statistigz.common.dto.ErrorResponse;

public class ServiceException extends RuntimeException implements CustomException {
    private static final int code = 4;
    private final String serviceName;

    public ServiceException(String serviceName, String message) {
        super(message);
        this.serviceName = serviceName;
    }

    @Override
    public ErrorResponse getResponse() {
        return new ErrorResponse(code, getMessage() + " in service " + serviceName);
    }
}
