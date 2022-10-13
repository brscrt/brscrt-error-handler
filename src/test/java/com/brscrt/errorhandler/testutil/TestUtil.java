package com.brscrt.errorhandler.testutil;

import com.brscrt.errorhandler.model.Error;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    public static void assertErrorResponse(ResponseEntity<Error> result, HttpStatus expectedStatus) {
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getBody());
        Assertions.assertEquals(expectedStatus, result.getStatusCode());
        Assertions.assertEquals(MediaType.APPLICATION_PROBLEM_JSON, result.getHeaders().getContentType());
        Error error = result.getBody();
        Assertions.assertEquals(String.valueOf(expectedStatus.value()), error.getCode());
        Assertions.assertEquals("reason", error.getReason());
        Assertions.assertEquals("message", error.getMessage());
        Assertions.assertEquals(expectedStatus.getReasonPhrase(), error.getStatus());
        Assertions.assertEquals("referenceError", error.getReferenceError());
        Assertions.assertEquals("baseType", error.getBaseType());
        Assertions.assertEquals("type", error.getType());
        Assertions.assertEquals("schemaLocation", error.getSchemaLocation());
    }

    public static void assertErrorResponse(ResponseEntity<Error> result, HttpStatus expectedStatus, String reason,
                                           String referenceError) {
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getBody());
        Assertions.assertEquals(expectedStatus, result.getStatusCode());
        Assertions.assertEquals(MediaType.APPLICATION_PROBLEM_JSON, result.getHeaders().getContentType());
        Error error = result.getBody();
        Assertions.assertEquals(String.valueOf(expectedStatus.value()), error.getCode());
        Assertions.assertEquals(reason, error.getReason());
        Assertions.assertNull(error.getMessage());
        Assertions.assertEquals(expectedStatus.getReasonPhrase(), error.getStatus());
        Assertions.assertEquals(referenceError, error.getReferenceError());
        Assertions.assertNull(error.getBaseType());
        Assertions.assertNull(error.getType());
        Assertions.assertNull(error.getSchemaLocation());
    }

    public static Error generateDefaultError() {
        return Error.builder().code("code").reason("reason").message("message").status("status")
                .referenceError("referenceError").baseType("baseType").schemaLocation("schemaLocation").type("type")
                .build();
    }
}
