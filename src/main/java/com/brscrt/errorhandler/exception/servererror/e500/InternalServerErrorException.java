package com.brscrt.errorhandler.exception.servererror.e500;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class InternalServerErrorException extends ApiException {
    private static final String REASON = "Internal Server Error";

    public InternalServerErrorException(@Nullable String referenceError) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }

    protected InternalServerErrorException(@NotNull Error error) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, error);
    }
}
