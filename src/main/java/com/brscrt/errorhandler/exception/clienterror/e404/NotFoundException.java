package com.brscrt.errorhandler.exception.clienterror.e404;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class NotFoundException extends ApiException {
    private static final String REASON = "The requested resource can not be found.";

    public NotFoundException(@Nullable String referenceError) {
        super(HttpStatus.NOT_FOUND, Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }

    protected NotFoundException(@NotNull Error error) {
        super(HttpStatus.NOT_FOUND, error);
    }
}
