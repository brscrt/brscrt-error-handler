package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InvalidDateExceptionTest {
    private static final String REASON = "Invalid date value: %s for %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        String field = "field";
        String value = "value";
        //when
        InvalidDateException invalidDateException = new InvalidDateException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(invalidDateException.getResponse(), httpStatus,
                String.format(REASON, value, field), referenceError);
    }
}