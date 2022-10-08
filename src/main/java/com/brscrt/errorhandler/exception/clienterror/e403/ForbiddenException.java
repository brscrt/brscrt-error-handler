package com.brscrt.errorhandler.exception.clienterror.e403;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class ForbiddenException extends ApiException {
    private static final String REASON = "Access is forbidden!";

    public ForbiddenException(@Nullable String referenceError) {
        super(HttpStatus.FORBIDDEN, Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }

    protected ForbiddenException(@NotNull Error error) {
        super(HttpStatus.FORBIDDEN, error);
    }
}
