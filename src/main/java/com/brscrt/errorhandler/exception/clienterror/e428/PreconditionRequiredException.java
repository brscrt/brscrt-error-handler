package com.brscrt.errorhandler.exception.clienterror.e428;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public abstract class PreconditionRequiredException extends ApiException {

    protected static final HttpStatus HTTP_STATUS = HttpStatus.PRECONDITION_REQUIRED;

    protected PreconditionRequiredException(@NotNull Error error) {
        super(HTTP_STATUS, error);
    }

}
