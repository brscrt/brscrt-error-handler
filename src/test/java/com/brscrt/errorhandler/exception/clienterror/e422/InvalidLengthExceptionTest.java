package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InvalidLengthExceptionTest {
    private static final String REASON = "Invalid length: %s for %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        String field = "field";
        String value = "value";
        //when
        InvalidLengthException invalidLengthException = new InvalidLengthException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(invalidLengthException.getResponse(), httpStatus,
                String.format(REASON, value, field), referenceError);
    }
}