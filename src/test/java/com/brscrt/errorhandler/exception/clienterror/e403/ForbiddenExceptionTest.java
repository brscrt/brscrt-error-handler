package com.brscrt.errorhandler.exception.clienterror.e403;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ForbiddenExceptionTest {

    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        ForbiddenException forbiddenException = new ForbiddenException(error);
        //then
        Assertions.assertNotNull(forbiddenException);
        TestUtil.assertErrorResponse(forbiddenException.getResponse(), ForbiddenException.HTTP_STATUS);
    }

    @Test
    void givenReferenceError_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        //when
        ForbiddenException forbiddenException = new ForbiddenException(referenceError);
        //then
        Assertions.assertNotNull(forbiddenException);
        TestUtil.assertErrorResponse(forbiddenException.getResponse(), ForbiddenException.HTTP_STATUS,
                ForbiddenException.REASON, referenceError);
    }
}