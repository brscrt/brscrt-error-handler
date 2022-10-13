package com.brscrt.errorhandler.exception.clienterror.e405;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodNotAllowedExceptionTest {

    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        MethodNotAllowedException methodNotAllowedException = new MethodNotAllowedException(error);
        //then
        Assertions.assertNotNull(methodNotAllowedException);
        TestUtil.assertErrorResponse(methodNotAllowedException.getResponse(), MethodNotAllowedException.HTTP_STATUS);
    }

    @Test
    void givenParameters_whenConstructException_thenCorrectlyInitialized() {
        //given
        String method = "method";
        String resource = "resource";
        //when
        MethodNotAllowedException methodNotAllowedException = new MethodNotAllowedException(method, resource);
        //then
        Assertions.assertNotNull(methodNotAllowedException);
        TestUtil.assertErrorResponse(methodNotAllowedException.getResponse(), MethodNotAllowedException.HTTP_STATUS,
                String.format(MethodNotAllowedException.REASON, method, resource), null);
    }
}