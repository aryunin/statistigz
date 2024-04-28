package com.statistigz.rcm.exception.handler;

import com.statistigz.common.dto.ErrorResponse;
import com.statistigz.rcm.exception.*;
import com.statistigz.rcm.util.CustomLogger;
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

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestException(CustomException e) {
        logger.debug(this, "handleInvalidRequestException(): " + e);
        return e.getResponse();
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleServiceException(CustomException e) {
        logger.debug(this, "handleServiceException(): " + e);
        return e.getResponse();
    }

    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnknownException(CustomException e) {
        logger.debug(this, "handleUnknownException(): " + e);
        return e.getResponse();
    }

}
