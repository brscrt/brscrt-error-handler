package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.model.Error;

public final class MissingFieldException extends UnprocessableEntityException {

    public MissingFieldException(String... attributes) {
        super(Error.builder()
                .reason(getReason("Missing Fields: %s", attributes))
                .message("There are missing fields.")
                .build());
    }

    public MissingFieldException(String referenceError, String... attributes) {
        super(Error.builder()
                .reason(getReason("Missing Fields: %s", attributes))
                .message("There are missing fields.")
                .referenceError(referenceError)
                .build());
    }
}
