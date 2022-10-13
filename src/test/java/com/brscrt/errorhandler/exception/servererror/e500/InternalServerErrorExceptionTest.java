package com.brscrt.errorhandler.exception.servererror.e500;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InternalServerErrorExceptionTest {
    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        InternalServerErrorException internalServerErrorException = new InternalServerErrorException(error);
        //then
        Assertions.assertNotNull(internalServerErrorException);
        TestUtil.assertErrorResponse(internalServerErrorException.getResponse(), InternalServerErrorException.HTTP_STATUS);
    }

    @Test
    void givenReferenceError_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        //when
        InternalServerErrorException internalServerErrorException = new InternalServerErrorException(referenceError);
        //then
        Assertions.assertNotNull(internalServerErrorException);
        TestUtil.assertErrorResponse(internalServerErrorException.getResponse(), InternalServerErrorException.HTTP_STATUS,
                InternalServerErrorException.REASON, referenceError);
    }
}