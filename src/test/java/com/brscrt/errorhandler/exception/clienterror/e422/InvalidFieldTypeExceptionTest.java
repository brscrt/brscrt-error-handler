package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InvalidFieldTypeExceptionTest {
    private static final String REASON = "Invalid field type: %s for %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        String field = "field";
        String value = "value";
        //when
        InvalidFieldTypeException invalidFieldTypeException = new InvalidFieldTypeException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(invalidFieldTypeException.getResponse(), httpStatus,
                String.format(REASON, value, field), referenceError);
    }
}