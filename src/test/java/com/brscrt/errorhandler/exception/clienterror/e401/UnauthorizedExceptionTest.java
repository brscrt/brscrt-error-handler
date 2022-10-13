package com.brscrt.errorhandler.exception.clienterror.e401;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnauthorizedExceptionTest {

    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        UnauthorizedException unauthorizedException = new UnauthorizedException(error);
        //then
        Assertions.assertNotNull(unauthorizedException);
        TestUtil.assertErrorResponse(unauthorizedException.getResponse(), UnauthorizedException.HTTP_STATUS);
    }

    @Test
    void givenReferenceError_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        //when
        UnauthorizedException unauthorizedException = new UnauthorizedException(referenceError);
        //then
        Assertions.assertNotNull(unauthorizedException);
        TestUtil.assertErrorResponse(unauthorizedException.getResponse(), UnauthorizedException.HTTP_STATUS,
                UnauthorizedException.REASON, referenceError);
    }
}