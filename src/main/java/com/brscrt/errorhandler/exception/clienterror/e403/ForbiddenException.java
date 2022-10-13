package com.brscrt.errorhandler.exception.clienterror.e403;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class ForbiddenException extends ApiException {

    protected static final String REASON = "Access is forbidden!";
    protected static final HttpStatus HTTP_STATUS = HttpStatus.FORBIDDEN;

    public ForbiddenException(@Nullable String referenceError) {
        super(HTTP_STATUS, Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }

    protected ForbiddenException(@NotNull Error error) {
        super(HTTP_STATUS, error);
    }
}
