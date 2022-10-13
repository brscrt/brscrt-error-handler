package com.brscrt.errorhandler.testutil;

import com.brscrt.errorhandler.model.Error;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.ResponseEntity;

public class TestUtil {

    public static void assertErrorResponse(ResponseEntity<Error> expected, ResponseEntity<Error> result) {
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getBody());
        Assertions.assertNotNull(expected);
        Assertions.assertNotNull(expected.getBody());
        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode());
        Assertions.assertEquals(expected.getBody().getCode(), result.getBody().getCode());
        Assertions.assertEquals(expected.getBody().getReason(), result.getBody().getReason());
        Assertions.assertEquals(expected.getBody().getMessage(), result.getBody().getMessage());
        Assertions.assertEquals(expected.getBody().getStatus(), result.getBody().getStatus());
        Assertions.assertEquals(expected.getBody().getReferenceError(), result.getBody().getReferenceError());
        Assertions.assertEquals(expected.getBody().getBaseType(), result.getBody().getBaseType());
        Assertions.assertEquals(expected.getBody().getType(), result.getBody().getType());
        Assertions.assertEquals(expected.getBody().getSchemaLocation(), result.getBody().getSchemaLocation());
    }
}
