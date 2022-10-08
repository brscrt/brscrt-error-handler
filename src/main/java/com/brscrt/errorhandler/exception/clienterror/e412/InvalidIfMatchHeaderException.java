package com.brscrt.errorhandler.exception.clienterror.e412;

import com.brscrt.errorhandler.model.Error;

import javax.validation.constraints.NotNull;

public final class InvalidIfMatchHeaderException extends PreconditionFailedException {

    private static final String REASON = "Invalid if-match header: %s";

    public InvalidIfMatchHeaderException(@NotNull String ifMatch) {
        super(Error.builder()
                .reason(String.format(REASON, ifMatch))
                .build());
    }

}
