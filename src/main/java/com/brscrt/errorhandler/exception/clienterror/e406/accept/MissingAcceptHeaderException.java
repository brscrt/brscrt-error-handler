package com.brscrt.errorhandler.exception.clienterror.e406.accept;

import com.brscrt.errorhandler.exception.clienterror.e406.NotAcceptableException;
import com.brscrt.errorhandler.model.Error;

public final class MissingAcceptHeaderException extends NotAcceptableException {

    private static final String REASON = "Missing Accept header";

    public MissingAcceptHeaderException() {
        super(Error.builder()
                .reason(REASON)
                .build());
    }
}
