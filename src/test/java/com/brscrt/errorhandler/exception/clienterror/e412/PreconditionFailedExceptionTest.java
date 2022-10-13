package com.brscrt.errorhandler.exception.clienterror.e412;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;

class PreconditionFailedExceptionTest {
    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        PreconditionFailedException preconditionFailedException = new PreconditionFailedException(error) {
        };
        //then
        TestUtil.assertErrorResponse(preconditionFailedException.getResponse(), PreconditionFailedException.HTTP_STATUS);
    }
}