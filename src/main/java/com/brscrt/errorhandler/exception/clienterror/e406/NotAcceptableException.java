package com.brscrt.errorhandler.exception.clienterror.e406;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public abstract class NotAcceptableException extends ApiException {

    protected static final HttpStatus HTTP_STATUS = HttpStatus.NOT_ACCEPTABLE;

    protected NotAcceptableException(@NotNull Error error) {
        super(HTTP_STATUS, error);
    }

}
