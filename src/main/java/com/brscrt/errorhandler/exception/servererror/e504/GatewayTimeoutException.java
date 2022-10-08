package com.brscrt.errorhandler.exception.servererror.e504;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public abstract class GatewayTimeoutException extends ApiException {

    protected GatewayTimeoutException(@NotNull Error error) {
        super(HttpStatus.GATEWAY_TIMEOUT, error);
    }

}
