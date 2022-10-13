package com.brscrt.errorhandler.exception.servererror.e504;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class KafkaTimeoutExceptionTest {
    private static final String REASON = "Kafka timeout.";
    private static final HttpStatus httpStatus = HttpStatus.GATEWAY_TIMEOUT;

    @Test
    void givenNoParameter_whenConstructException_thenCorrectlyInitialized() {
        //given
        //when
        KafkaTimeoutException kafkaTimeoutException = new KafkaTimeoutException();
        //then
        TestUtil.assertErrorResponse(kafkaTimeoutException.getResponse(), httpStatus, REASON, null);
    }
}