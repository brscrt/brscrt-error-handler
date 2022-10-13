package com.brscrt.errorhandler.exception.servererror.e503;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class KafkaUnavailableExceptionTest {

    private static final String REASON = "Kafka is not available.";
    private static final HttpStatus httpStatus = HttpStatus.SERVICE_UNAVAILABLE;

    @Test
    void givenReferenceError_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        //when
        KafkaUnavailableException kafkaUnavailableException = new KafkaUnavailableException(referenceError);
        //then
        TestUtil.assertErrorResponse(kafkaUnavailableException.getResponse(), httpStatus, REASON, referenceError);
    }
}