package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InvalidFieldExceptionTest {
    private static final String REASON = "Invalid field value: %s for %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        String field = "field";
        String value = "value";
        //when
        InvalidFieldException invalidFieldException = new InvalidFieldException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(invalidFieldException.getResponse(), httpStatus,
                String.format(REASON, value, field), referenceError);
    }
}