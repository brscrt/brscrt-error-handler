package com.brscrt.errorhandler.exception;

import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public abstract class ApiException extends Exception {
    protected HttpStatus httpStatus;
    private final Error error;

    protected ApiException(HttpStatus httpStatus, Error error) {
        error.setCode(String.valueOf(HttpStatus.CONFLICT.value()));
        error.setStatus(HttpStatus.CONFLICT.getReasonPhrase());
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public ResponseEntity<Error> getResponse() {
        return ResponseEntity
                .status(httpStatus)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(error);
    }
}
