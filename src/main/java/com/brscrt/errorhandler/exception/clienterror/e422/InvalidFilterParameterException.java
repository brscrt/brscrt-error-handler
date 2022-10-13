package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.model.Error;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public final class InvalidFilterParameterException extends UnprocessableEntityException {

    private static final String REASON = "Invalid filter parameter: %s.";

    public InvalidFilterParameterException(@Nullable String referenceError, @NotNull String parameter) {
        super(Error.builder()
                .reason(String.format(REASON, parameter))
                .referenceError(referenceError)
                .build());
    }
}
