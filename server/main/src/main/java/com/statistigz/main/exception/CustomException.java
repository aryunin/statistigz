package com.statistigz.main.exception;

import com.statistigz.common.dto.ErrorResponse;

public interface CustomException {
    ErrorResponse getResponse();
}
