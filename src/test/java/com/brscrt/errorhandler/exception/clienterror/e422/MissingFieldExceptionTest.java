package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class MissingFieldExceptionTest {
    private static final String REASON = "Missing Fields: %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        String[] attributes = new String[]{"1", "2"};
        //when
        MissingFieldException missingFieldException = new MissingFieldException(referenceError, attributes);
        //then
        TestUtil.assertErrorResponse(missingFieldException.getResponse(), httpStatus,
                MissingFieldException.getReason(REASON, attributes), referenceError);
    }
}