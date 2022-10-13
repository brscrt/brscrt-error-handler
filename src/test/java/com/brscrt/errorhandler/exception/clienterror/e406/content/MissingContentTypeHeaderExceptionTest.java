package com.brscrt.errorhandler.exception.clienterror.e406.content;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class MissingContentTypeHeaderExceptionTest {

    private static final String REASON = "Missing Content-Type header.";
    private static final HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;

    @Test
    void givenNoParameter_whenConstructException_thenCorrectlyInitialized() {
        //given
        //when
        MissingContentTypeHeaderException missingContentTypeHeaderException = new MissingContentTypeHeaderException();
        //then
        TestUtil.assertErrorResponse(missingContentTypeHeaderException.getResponse(), httpStatus,
                REASON, null);
    }
}