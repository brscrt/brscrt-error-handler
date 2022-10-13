package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InvalidEnumExceptionTest {
    private static final String REASON = "Invalid enumeration value: %s for %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        String field = "field";
        String value = "value";
        //when
        InvalidEnumException invalidEnumException = new InvalidEnumException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(invalidEnumException.getResponse(), httpStatus,
                String.format(REASON, value, field), referenceError);
    }
}