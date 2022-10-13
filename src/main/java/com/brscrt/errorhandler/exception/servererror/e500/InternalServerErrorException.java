package com.brscrt.errorhandler.exception.servererror.e500;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class InternalServerErrorException extends ApiException {

    protected static final String REASON = "Internal Server Error.";
    protected static final HttpStatus HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public InternalServerErrorException(@Nullable String referenceError) {
        super(HTTP_STATUS, Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }

    protected InternalServerErrorException(@NotNull Error error) {
        super(HTTP_STATUS, error);
    }
}
