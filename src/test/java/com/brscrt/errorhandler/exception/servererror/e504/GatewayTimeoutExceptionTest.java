package com.brscrt.errorhandler.exception.servererror.e504;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;

class GatewayTimeoutExceptionTest {
    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        GatewayTimeoutException gatewayTimeoutException = new GatewayTimeoutException(error) {
        };
        //then
        TestUtil.assertErrorResponse(gatewayTimeoutException.getResponse(), GatewayTimeoutException.HTTP_STATUS);
    }
}