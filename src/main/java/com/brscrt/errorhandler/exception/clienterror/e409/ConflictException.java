package com.brscrt.errorhandler.exception.clienterror.e409;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;

public final class ConflictException extends ApiException {

    public ConflictException() {
        super(HttpStatus.CONFLICT, Error.builder()
                .reason("There are conflicts.")
                .build());
    }
}
