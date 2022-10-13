package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class UnprocessablePayloadExceptionTest {
    private static final String REASON = "Unprocessable payload.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenReferenceError_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        //when
        UnprocessablePayloadException unprocessablePayloadException = new UnprocessablePayloadException(referenceError);
        //then
        TestUtil.assertErrorResponse(unprocessablePayloadException.getResponse(), httpStatus, REASON, referenceError);
    }
}