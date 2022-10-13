package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class AdditionalFieldExceptionTest {
    private static final String REASON = "Additional Fields: %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        String[] attributes = new String[]{"1", "2"};
        //when
        AdditionalFieldException additionalFieldException = new AdditionalFieldException(referenceError, attributes);
        //then
        TestUtil.assertErrorResponse(additionalFieldException.getResponse(), httpStatus,
                AdditionalFieldException.getReason(REASON, attributes), referenceError);
    }
}