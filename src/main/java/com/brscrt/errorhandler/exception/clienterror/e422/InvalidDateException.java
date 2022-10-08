package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.model.Error;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public final class InvalidDateException extends UnprocessableEntityException {

    private static final String REASON = "Invalid date value: %s for %s";

    public InvalidDateException(@Nullable String referenceError,
                                @NotNull String field,
                                @NotNull String value) {
        super(Error.builder()
                .reason(String.format(REASON, value, field))
                .referenceError(referenceError)
                .build());
    }
}
