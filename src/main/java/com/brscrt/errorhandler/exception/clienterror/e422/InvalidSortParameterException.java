package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.model.Error;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public final class InvalidSortParameterException extends UnprocessableEntityException {

    private static final String REASON = "Invalid sort parameter: %s.";

    public InvalidSortParameterException(@Nullable String referenceError, @NotNull String parameter) {
        super(Error.builder()
                .reason(String.format(REASON, parameter))
                .referenceError(referenceError)
                .build());
    }
}
