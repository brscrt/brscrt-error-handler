package com.brscrt.errorhandler.exception;

import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;

public abstract class ApiException extends Exception {
    private final HttpStatus httpStatus;
    private final Error error;

    protected ApiException(@NotNull HttpStatus httpStatus, @NotNull Error error) {
        error.setCode(String.valueOf(httpStatus.value()));
        error.setStatus(httpStatus.getReasonPhrase());
        this.error = error;
        this.httpStatus = httpStatus;
    }

    @NotNull
    public ResponseEntity<Error> getResponse() {
        return ResponseEntity
                .status(httpStatus)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(error);
    }
}
