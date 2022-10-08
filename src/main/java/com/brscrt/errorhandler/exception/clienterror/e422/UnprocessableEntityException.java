package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public abstract class UnprocessableEntityException extends ApiException {
    protected UnprocessableEntityException(@NotNull Error error) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, error);
    }

    protected static String getReason(@NotNull String reason, @NotNull String... attributes) {
        return String.format(reason, String.join(",", attributes));
    }
}
