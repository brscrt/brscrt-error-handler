package com.brscrt.errorhandler.exception.servererror.e504;

import com.brscrt.errorhandler.model.Error;

public final class KafkaTimeoutException extends GatewayTimeoutException {

    private static final String REASON = "Kafka timeout.";

    public KafkaTimeoutException() {
        super(Error.builder()
                .reason(REASON)
                .build());
    }
}
