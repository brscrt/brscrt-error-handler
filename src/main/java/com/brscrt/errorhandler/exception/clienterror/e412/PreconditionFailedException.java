package com.brscrt.errorhandler.exception.clienterror.e412;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public abstract class PreconditionFailedException extends ApiException {

    protected PreconditionFailedException(@NotNull Error error) {
        super(HttpStatus.PRECONDITION_FAILED, error);
    }

}
