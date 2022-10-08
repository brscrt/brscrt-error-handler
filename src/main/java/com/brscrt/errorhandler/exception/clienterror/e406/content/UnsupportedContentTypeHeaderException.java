package com.brscrt.errorhandler.exception.clienterror.e406.content;

import com.brscrt.errorhandler.exception.clienterror.e406.NotAcceptableException;
import com.brscrt.errorhandler.model.Error;

public final class UnsupportedContentTypeHeaderException extends NotAcceptableException {

    private static final String REASON = "Unsupported Content-Type header";

    public UnsupportedContentTypeHeaderException() {
        super(Error.builder()
                .reason(REASON)
                .build());
    }
}
