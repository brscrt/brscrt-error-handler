package com.brscrt.errorhandler.exception.clienterror.e404;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class NotFoundException extends ApiException {

    protected static final String REASON = "The requested resource can not be found.";
    protected static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

    public NotFoundException(@Nullable String referenceError) {
        super(HTTP_STATUS, Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }

    protected NotFoundException(@NotNull Error error) {
        super(HTTP_STATUS, error);
    }
}
