package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.model.Error;
import org.springframework.lang.Nullable;

public final class UnprocessablePayloadException extends UnprocessableEntityException {

    private static final String REASON = "Unprocessable payload.";

    public UnprocessablePayloadException(@Nullable String referenceError) {
        super(Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }
}
