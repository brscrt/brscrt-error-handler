package com.brscrt.errorhandler.exception.clienterror.e406.content;

import com.brscrt.errorhandler.exception.clienterror.e406.NotAcceptableException;
import com.brscrt.errorhandler.model.Error;

public final class MissingContentTypeHeaderException extends NotAcceptableException {

    private static final String REASON = "Missing Content-Type header.";

    public MissingContentTypeHeaderException() {
        super(Error.builder()
                .reason(REASON)
                .build());
    }
}
