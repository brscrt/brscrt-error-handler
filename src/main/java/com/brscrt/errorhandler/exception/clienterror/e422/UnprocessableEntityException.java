package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;

public abstract class UnprocessableEntityException extends ApiException {
    public UnprocessableEntityException(Error error) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, error);
    }

    protected static String getReason(String reason, String... attributes) {
        return String.format(reason, String.join(",", attributes));
    }
}
