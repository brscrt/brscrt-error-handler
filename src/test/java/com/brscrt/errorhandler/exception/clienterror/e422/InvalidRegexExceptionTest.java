package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InvalidRegexExceptionTest {
    private static final String REASON = "Invalid regex value: %s for %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        String field = "field";
        String value = "value";
        //when
        InvalidRegexException invalidRegexException = new InvalidRegexException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(invalidRegexException.getResponse(), httpStatus,
                String.format(REASON, value, field), referenceError);
    }
}