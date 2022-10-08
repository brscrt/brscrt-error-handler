package com.brscrt.errorhandler.exception.servererror.e504;

import com.brscrt.errorhandler.exception.servererror.e503.ServiceUnavailableException;
import com.brscrt.errorhandler.model.Error;

public final class KafkaTimeoutException extends ServiceUnavailableException {

    private static final String REASON = "Kafka timeout.";

    public KafkaTimeoutException() {
        super(Error.builder()
                .reason(REASON)
                .build());
    }
}
