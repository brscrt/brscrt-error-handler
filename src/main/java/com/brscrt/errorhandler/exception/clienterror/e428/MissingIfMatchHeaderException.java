package com.brscrt.errorhandler.exception.clienterror.e428;

import com.brscrt.errorhandler.model.Error;
import org.springframework.lang.Nullable;

public final class MissingIfMatchHeaderException extends PreconditionRequiredException {

    private static final String REASON = "Missing if-match header";

    public MissingIfMatchHeaderException(@Nullable String referenceError) {
        super(Error.builder()
                .reason(REASON)
                .build());
    }
}
