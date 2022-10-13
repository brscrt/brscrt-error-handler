package com.brscrt.errorhandler.exception.clienterror.e412;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InvalidIfMatchHeaderExceptionTest {

    private static final String REASON = "Invalid if-match header: %s.";
    private static final HttpStatus httpStatus = HttpStatus.PRECONDITION_FAILED;

    @Test
    void givenIfMatch_whenConstructException_thenCorrectlyInitialized() {
        //given
        String ifMatch = "ifMatch";
        //when
        InvalidIfMatchHeaderException invalidIfMatchHeaderException =
                new InvalidIfMatchHeaderException(ifMatch);
        //then
        TestUtil.assertErrorResponse(invalidIfMatchHeaderException.getResponse(), httpStatus,
                String.format(REASON, ifMatch), null);
    }
}