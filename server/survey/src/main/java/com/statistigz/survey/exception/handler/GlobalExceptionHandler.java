package com.statistigz.survey.exception.handler;

import com.statistigz.common.dto.ErrorResponse;
import com.statistigz.survey.exception.CustomException;
import com.statistigz.survey.exception.MappingException;
import com.statistigz.survey.exception.NotFoundException;
import com.statistigz.survey.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public final class GlobalExceptionHandler {
    private final CustomLogger logger;

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(CustomException e) {
        logger.debug(this, "handleNotFoundException(): " + e);
        return e.getResponse();
    }

    @ExceptionHandler(MappingException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleMappingException(CustomException e) {
        logger.debug(this, "handleMappingException(): " + e);
        return e.getResponse();
    }
}
