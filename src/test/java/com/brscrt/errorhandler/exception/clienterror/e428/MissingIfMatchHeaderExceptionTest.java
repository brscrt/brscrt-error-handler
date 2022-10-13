package com.brscrt.errorhandler.exception.clienterror.e428;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class MissingIfMatchHeaderExceptionTest {
    private static final String REASON = "Missing if-match header.";
    private static final HttpStatus httpStatus = HttpStatus.PRECONDITION_REQUIRED;

    @Test
    void givenReferenceError_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        //when
        MissingIfMatchHeaderException missingIfMatchHeaderException = new MissingIfMatchHeaderException(referenceError);
        //then
        TestUtil.assertErrorResponse(missingIfMatchHeaderException.getResponse(), httpStatus, REASON, referenceError);
    }
}