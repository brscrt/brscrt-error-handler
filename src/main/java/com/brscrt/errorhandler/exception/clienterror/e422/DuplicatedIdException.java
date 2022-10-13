package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.model.Error;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public final class DuplicatedIdException extends UnprocessableEntityException {

    private static final String REASON = "Duplicated id: %s.";

    public DuplicatedIdException(@Nullable String referenceError, @NotNull String id) {
        super(Error.builder()
                .reason(String.format(REASON, id))
                .referenceError(referenceError)
                .build());
    }
}
