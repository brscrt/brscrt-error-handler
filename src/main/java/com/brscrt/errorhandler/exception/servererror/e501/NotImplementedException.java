package com.brscrt.errorhandler.exception.servererror.e501;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class NotImplementedException extends ApiException {

    protected static final String REASON = "Not Implemented.";
    protected static final HttpStatus HTTP_STATUS = HttpStatus.NOT_IMPLEMENTED;

    public NotImplementedException(@Nullable String referenceError) {
        super(HTTP_STATUS, Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }

    protected NotImplementedException(@NotNull Error error) {
        super(HTTP_STATUS, error);
    }
}
