package com.brscrt.errorhandler.exception.clienterror.e428;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;

class PreconditionRequiredExceptionTest {
    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        PreconditionRequiredException preconditionRequiredException = new PreconditionRequiredException(error) {
        };
        //then
        TestUtil.assertErrorResponse(preconditionRequiredException.getResponse(), PreconditionRequiredException.HTTP_STATUS);
    }
}