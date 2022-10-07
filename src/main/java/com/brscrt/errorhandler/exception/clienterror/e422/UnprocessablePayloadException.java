package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.model.Error;

public final class UnprocessablePayloadException extends UnprocessableEntityException {

    public UnprocessablePayloadException() {
        super(Error.builder()
                .reason("Unprocessable payload")
                .message("Unprocessable payload")
                .build());
    }
}
