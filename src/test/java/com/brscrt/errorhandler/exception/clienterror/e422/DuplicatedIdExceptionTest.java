package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class DuplicatedIdExceptionTest {
    private static final String REASON = "Duplicated id: %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String referenceError = "test ref";
        String id = "id";
        //when
        DuplicatedIdException duplicatedIdException = new DuplicatedIdException(referenceError, id);
        //then
        TestUtil.assertErrorResponse(duplicatedIdException.getResponse(), httpStatus,
                String.format(REASON, id), referenceError);
    }
}