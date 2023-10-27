package com.statistigz.main.exception.handler;

import com.statistigz.common.dto.ErrorResponse;
import com.statistigz.main.exception.CustomException;
import com.statistigz.main.exception.InvalidRequestException;
import com.statistigz.main.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(CustomException e) {
        return e.getResponse();
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestException(CustomException e) {
        return e.getResponse();
    }
}
