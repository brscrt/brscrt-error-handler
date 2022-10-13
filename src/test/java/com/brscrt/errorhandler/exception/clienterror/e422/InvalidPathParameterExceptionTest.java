package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InvalidPathParameterExceptionTest {
    private static final String REASON = "Invalid path parameter.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenReferenceError_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        //when
        InvalidPathParameterException invalidPathParameterException = new InvalidPathParameterException(referenceError);
        //then
        TestUtil.assertErrorResponse(invalidPathParameterException.getResponse(), httpStatus, REASON, referenceError);
    }
}