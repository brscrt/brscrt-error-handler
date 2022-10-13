package com.brscrt.errorhandler.exception.servererror.e503;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;

class ServiceUnavailableExceptionTest {
    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        ServiceUnavailableException serviceUnavailableException = new ServiceUnavailableException(error) {
        };
        //then
        TestUtil.assertErrorResponse(serviceUnavailableException.getResponse(), ServiceUnavailableException.HTTP_STATUS);
    }
}