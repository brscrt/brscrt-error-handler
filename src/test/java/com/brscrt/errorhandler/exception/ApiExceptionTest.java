package com.brscrt.errorhandler.exception;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ApiExceptionTest {

    private final HttpStatus defaultHttpStatus = HttpStatus.BAD_REQUEST;

    private ApiException generateDefaultApiException() {
        return new ApiException(defaultHttpStatus, TestUtil.generateDefaultError()) {
        };
    }

    @Test
    void givenNoParameter_whenGetResponse_thenResponseIsCorrect() {
        //given
        ApiException apiException = generateDefaultApiException();
        //when
        ResponseEntity<Error> response = apiException.getResponse();
        //then
        TestUtil.assertErrorResponse(response, defaultHttpStatus);
    }
}