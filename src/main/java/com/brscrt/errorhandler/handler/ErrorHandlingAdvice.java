package com.brscrt.errorhandler.handler;


import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ErrorHandlingAdvice {
    private static final String ERROR = "Got an error";

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Error> handleCustomException(ApiException apiException) {
        log.error(ERROR, apiException);
        return apiException.getResponse();
    }

}
