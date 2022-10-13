package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InvalidFilterParameterExceptionTest {
    private static final String REASON = "Invalid filter parameter: %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        String parameter = "parameter";
        //when
        InvalidFilterParameterException invalidFilterParameterException =
                new InvalidFilterParameterException(referenceError, parameter);
        //then
        TestUtil.assertErrorResponse(invalidFilterParameterException.getResponse(), httpStatus,
                String.format(REASON, parameter), referenceError);
    }
}