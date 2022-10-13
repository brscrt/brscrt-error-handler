package com.brscrt.errorhandler.exception.clienterror.e404;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NotFoundExceptionTest {

    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        NotFoundException notFoundException = new NotFoundException(error);
        //then
        Assertions.assertNotNull(notFoundException);
        TestUtil.assertErrorResponse(notFoundException.getResponse(), NotFoundException.HTTP_STATUS);
    }

    @Test
    void givenReferenceError_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        //when
        NotFoundException notFoundException = new NotFoundException(referenceError);
        //then
        Assertions.assertNotNull(notFoundException);
        TestUtil.assertErrorResponse(notFoundException.getResponse(), NotFoundException.HTTP_STATUS,
                NotFoundException.REASON, referenceError);
    }
}