package com.brscrt.errorhandler.exception.clienterror.e405;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;

public final class MethodNotAllowedException extends ApiException {
    private static final String REASON = "The %s is not allowed for the %s";

    public MethodNotAllowedException(String method, String resource) {
        super(HttpStatus.METHOD_NOT_ALLOWED, Error.builder()
                .reason(String.format(REASON, method, resource))
                .build());
    }
}
