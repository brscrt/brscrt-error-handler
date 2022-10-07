package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.model.Error;

public final class AdditionalFieldException extends UnprocessableEntityException {

    public AdditionalFieldException(String referenceError, String... attributes) {
        super(Error.builder()
                .reason(getReason("Additional Fields: %s", attributes))
                .message("There are additional fields.")
                .referenceError(referenceError)
                .build());
    }
}
