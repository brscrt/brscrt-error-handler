package com.brscrt.errorhandler.exception.servererror.e503;

import com.brscrt.errorhandler.exception.servererror.e504.GatewayTimeoutException;
import com.brscrt.errorhandler.model.Error;
import org.springframework.lang.Nullable;

public final class KafkaUnavailableException extends GatewayTimeoutException {

    private static final String REASON = "Kafka is not available.";

    public KafkaUnavailableException(@Nullable String referenceError) {
        super(Error.builder()
                .reason(REASON)
                .referenceError(referenceError)
                .build());
    }
}
