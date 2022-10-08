package com.brscrt.errorhandler.handler;


import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.factory.ExceptionFactory;
import com.brscrt.errorhandler.model.Error;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class ErrorHandlingAdvice implements ApiExceptionHandler {
    private static final String ERROR = "The api got an error.";

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Error> handleApiException(ApiException exception) {
        log.error(ERROR, exception);
        return exception.getResponse();
    }

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<Error> handlePropertyReferenceException(PropertyReferenceException exception) {
        ApiException apiException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidSortParameterException(exception.getMessage(), exception.getPropertyName());
        log.error(ERROR, apiException);
        return apiException.getResponse();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Error> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException exception, HttpServletRequest request) {
        ApiException apiException = ExceptionFactory.Client.MethodNotAllowed
                .throwMethodNotAllowedException(exception.getMethod(), request.getRequestURI());
        log.error(ERROR, apiException);
        return apiException.getResponse();
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<Error> handleNotAcceptableAcceptHeaderException() {
        ApiException apiException = ExceptionFactory.Client.NotAcceptable.throwUnsupportedAcceptHeaderException();
        log.error(ERROR, apiException);
        return apiException.getResponse();
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Error> handleNotAcceptableContentTypeHeaderException() {
        ApiException apiException = ExceptionFactory.Client.NotAcceptable.throwUnsupportedContentTypeHeaderException();
        log.error(ERROR, apiException);
        return apiException.getResponse();
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public ResponseEntity<Error> handleOtherException(Exception exception) {
        ApiException apiException = ExceptionFactory.Server.InternalServerError
                .throwInternalServerErrorException(exception.getMessage());
        log.error(ERROR, apiException);
        return apiException.getResponse();
    }

}
