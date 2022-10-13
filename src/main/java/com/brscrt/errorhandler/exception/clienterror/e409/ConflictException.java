package com.brscrt.errorhandler.exception.clienterror.e409;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class ConflictException extends ApiException {

    protected static final String REASON = "There are conflicts.";
    protected static final HttpStatus HTTP_STATUS = HttpStatus.CONFLICT;

    public ConflictException(@Nullable String referenceError) {
        super(HTTP_STATUS, Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }

    protected ConflictException(@NotNull Error error) {
        super(HTTP_STATUS, error);
    }
}
