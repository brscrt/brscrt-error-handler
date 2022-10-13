package com.brscrt.errorhandler.exception.clienterror.e406.other;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class NotAcceptableHeaderExceptionTest {

    private static final String REASON = "Missing or unsupported value for %s header.";
    private static final HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;

    @Test
    void givenHeader_whenConstructException_thenCorrectlyInitialized() {
        //given
        String header = "header";
        //when
        NotAcceptableHeaderException notAcceptableHeaderException = new NotAcceptableHeaderException(header);
        //then
        TestUtil.assertErrorResponse(notAcceptableHeaderException.getResponse(), httpStatus,
                String.format(REASON, header), null);
    }
}