package com.brscrt.errorhandler.exception.clienterror.e409;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConflictExceptionTest {
    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        ConflictException conflictException = new ConflictException(error);
        //then
        Assertions.assertNotNull(conflictException);
        TestUtil.assertErrorResponse(conflictException.getResponse(), ConflictException.HTTP_STATUS);
    }

    @Test
    void givenReferenceError_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        //when
        ConflictException conflictException = new ConflictException(referenceError);
        //then
        Assertions.assertNotNull(conflictException);
        TestUtil.assertErrorResponse(conflictException.getResponse(), ConflictException.HTTP_STATUS,
                ConflictException.REASON, referenceError);
    }
}