package com.brscrt.errorhandler.exception.clienterror.e406;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;

class NotAcceptableExceptionTest {

    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        NotAcceptableException notAcceptableException = new NotAcceptableException(error) {
        };
        //then
        TestUtil.assertErrorResponse(notAcceptableException.getResponse(), NotAcceptableException.HTTP_STATUS);
    }

}