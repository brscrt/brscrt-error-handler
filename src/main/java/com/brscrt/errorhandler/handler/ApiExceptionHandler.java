package com.brscrt.errorhandler.handler;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.ResponseEntity;

public interface ApiExceptionHandler {
    ResponseEntity<Error> handleApiException(ApiException apiException);
}
