package com.brscrt.errorhandler.exception.clienterror.e406.accept;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class UnsupportedAcceptHeaderExceptionTest {

    private static final String REASON = "Unsupported Accept header.";
    private static final HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;

    @Test
    void givenNoParameter_whenConstructException_thenCorrectlyInitialized() {
        //given
        //when
        UnsupportedAcceptHeaderException unsupportedAcceptHeaderException = new UnsupportedAcceptHeaderException();
        //then
        TestUtil.assertErrorResponse(unsupportedAcceptHeaderException.getResponse(), httpStatus,
                REASON, null);
    }
}