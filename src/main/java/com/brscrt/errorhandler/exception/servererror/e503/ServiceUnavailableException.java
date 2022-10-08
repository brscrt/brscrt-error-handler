package com.brscrt.errorhandler.exception.servererror.e503;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public abstract class ServiceUnavailableException extends ApiException {

    protected ServiceUnavailableException(@NotNull Error error) {
        super(HttpStatus.SERVICE_UNAVAILABLE, error);
    }

}
