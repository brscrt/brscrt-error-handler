package com.brscrt.errorhandler.exception.clienterror.e401;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class UnauthorizedException extends ApiException {
    private static final String REASON = "Access is unauthorized!";

    public UnauthorizedException(@Nullable String referenceError) {
        super(HttpStatus.UNAUTHORIZED, Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }

    protected UnauthorizedException(@NotNull Error error) {
        super(HttpStatus.UNAUTHORIZED, error);
    }
}
