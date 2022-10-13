package com.brscrt.errorhandler.exception.servererror.e501;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NotImplementedExceptionTest {
    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        NotImplementedException notImplementedException = new NotImplementedException(error);
        //then
        Assertions.assertNotNull(notImplementedException);
        TestUtil.assertErrorResponse(notImplementedException.getResponse(), NotImplementedException.HTTP_STATUS);
    }

    @Test
    void givenReferenceError_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        //when
        NotImplementedException notImplementedException = new NotImplementedException(referenceError);
        //then
        Assertions.assertNotNull(notImplementedException);
        TestUtil.assertErrorResponse(notImplementedException.getResponse(), NotImplementedException.HTTP_STATUS,
                NotImplementedException.REASON, referenceError);
    }
}