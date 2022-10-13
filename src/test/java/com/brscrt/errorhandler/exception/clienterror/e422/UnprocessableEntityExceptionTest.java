package com.brscrt.errorhandler.exception.clienterror.e422;

import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnprocessableEntityExceptionTest {
    @Test
    void givenError_whenConstructException_thenCorrectlyInitialized() {
        //given
        Error error = TestUtil.generateDefaultError();
        //when
        UnprocessableEntityException unprocessableEntityException = new UnprocessableEntityException(error) {
        };
        //then
        TestUtil.assertErrorResponse(unprocessableEntityException.getResponse(), UnprocessableEntityException.HTTP_STATUS);
    }

    @Test
    void givenOnlySimpleReason_whenGetReason_thenReturnCorrect() {
        //given
        String reason = "reason";
        //when
        String result = UnprocessableEntityException.getReason(reason);
        //then
        Assertions.assertEquals(reason, result);
    }

    @Test
    void givenOnlyReason_whenGetReason_thenReturnCorrect() {
        //given
        String reason = "reason %s";
        //when
        String result = UnprocessableEntityException.getReason(reason);
        //then
        Assertions.assertEquals("reason ", result);
    }

    @Test
    void givenOnlyAttributes_whenGetReason_thenThrowException() {
        //given
        String[] attributes = new String[]{"1", "2"};
        //when, then
        Assertions.assertThrows(NullPointerException.class,
                () -> UnprocessableEntityException.getReason(null, attributes));
    }

    @Test
    void givenAttributesAndSimpleReason_whenGetReason_thenReturnCorrect() {
        //given
        String reason = "reason";
        String[] attributes = new String[]{"1", "2"};
        //when
        String result = UnprocessableEntityException.getReason(reason, attributes);
        //then
        Assertions.assertEquals(reason, result);
    }

    @Test
    void givenAttributesAndReason_whenGetReason_thenReturnCorrect() {
        //given
        String reason = "reason %s";
        String[] attributes = new String[]{"1", "2"};
        //when
        String result = UnprocessableEntityException.getReason(reason, attributes);
        //then
        Assertions.assertEquals("reason 1,2", result);
    }
}