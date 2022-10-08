package com.brscrt.errorhandler.exception.clienterror.e406.accept;

import com.brscrt.errorhandler.exception.clienterror.e406.NotAcceptableException;
import com.brscrt.errorhandler.model.Error;

public final class UnsupportedAcceptHeaderException extends NotAcceptableException {

    private static final String REASON = "Unsupported Accept header";

    public UnsupportedAcceptHeaderException() {
        super(Error.builder()
                .reason(REASON)
                .build());
    }
}
