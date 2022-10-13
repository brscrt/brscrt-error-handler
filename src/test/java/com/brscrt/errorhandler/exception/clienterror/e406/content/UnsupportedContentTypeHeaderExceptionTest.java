package com.brscrt.errorhandler.exception.clienterror.e406.content;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class UnsupportedContentTypeHeaderExceptionTest {

    private static final String REASON = "Unsupported Content-Type header.";
    private static final HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;

    @Test
    void givenNoParameter_whenConstructException_thenCorrectlyInitialized() {
        //given
        //when
        UnsupportedContentTypeHeaderException unsupportedContentTypeHeaderException =
                new UnsupportedContentTypeHeaderException();
        //then
        TestUtil.assertErrorResponse(unsupportedContentTypeHeaderException.getResponse(), httpStatus,
                REASON, null);
    }
}