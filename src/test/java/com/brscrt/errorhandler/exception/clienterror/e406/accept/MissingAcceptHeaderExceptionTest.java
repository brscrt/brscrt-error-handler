package com.brscrt.errorhandler.exception.clienterror.e406.accept;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class MissingAcceptHeaderExceptionTest {

    private static final String REASON = "Missing Accept header.";
    private static final HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;

    @Test
    void givenNoParameter_whenConstructException_thenCorrectlyInitialized() {
        //given
        //when
        MissingAcceptHeaderException missingAcceptHeaderException = new MissingAcceptHeaderException();
        //then
        TestUtil.assertErrorResponse(missingAcceptHeaderException.getResponse(), httpStatus, REASON, null);
    }

}