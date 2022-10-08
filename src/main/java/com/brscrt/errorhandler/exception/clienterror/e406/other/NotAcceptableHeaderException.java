package com.brscrt.errorhandler.exception.clienterror.e406.other;

import com.brscrt.errorhandler.exception.clienterror.e406.NotAcceptableException;
import com.brscrt.errorhandler.model.Error;

import javax.validation.constraints.NotNull;

public final class NotAcceptableHeaderException extends NotAcceptableException {

    private static final String REASON = "Missing or unsupported value for %s header";

    public NotAcceptableHeaderException(@NotNull String header) {
        super(Error.builder()
                .reason(String.format(REASON, header))
                .build());
    }
}
