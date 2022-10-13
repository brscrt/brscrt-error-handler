package com.brscrt.errorhandler.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ErrorTest {

    @Test
    void givenNewErrorWithNoFields_whenCheckFields_thenFieldsAreCorrect() {
        //given
        Error error = new Error.ErrorBuilder().build();

        //when, then
        Assertions.assertNull(error.getCode());
        Assertions.assertNull(error.getReason());
        Assertions.assertNull(error.getMessage());
        Assertions.assertNull(error.getStatus());
        Assertions.assertNull(error.getReferenceError());
        Assertions.assertNull(error.getBaseType());
        Assertions.assertNull(error.getSchemaLocation());
        Assertions.assertNull(error.getType());
    }

    @Test
    void givenNewErrorWithNoFieldsAndSetAll_whenCheckFields_thenFieldsAreCorrect() {
        //given
        Error error = new Error.ErrorBuilder().build();
        error.setCode("code");
        error.setReason("reason");
        error.setMessage("message");
        error.setStatus("status");
        error.setReferenceError("referenceError");
        error.setBaseType("baseType");
        error.setSchemaLocation("schemaLocation");
        error.setType("type");

        //when, then
        Assertions.assertEquals("code", error.getCode());
        Assertions.assertEquals("reason", error.getReason());
        Assertions.assertEquals("message", error.getMessage());
        Assertions.assertEquals("status", error.getStatus());
        Assertions.assertEquals("referenceError", error.getReferenceError());
        Assertions.assertEquals("baseType", error.getBaseType());
        Assertions.assertEquals("schemaLocation", error.getSchemaLocation());
        Assertions.assertEquals("type", error.getType());
    }

    @Test
    void givenNewErrorWithAllFields_whenCheckFields_thenFieldsAreCorrect() {
        //given
        Error error = new Error.ErrorBuilder().code("code").reason("reason").message("message").status("status")
                .referenceError("referenceError").baseType("baseType").schemaLocation("schemaLocation").type("type")
                .build();

        //when, then
        Assertions.assertEquals("code", error.getCode());
        Assertions.assertEquals("reason", error.getReason());
        Assertions.assertEquals("message", error.getMessage());
        Assertions.assertEquals("status", error.getStatus());
        Assertions.assertEquals("referenceError", error.getReferenceError());
        Assertions.assertEquals("baseType", error.getBaseType());
        Assertions.assertEquals("schemaLocation", error.getSchemaLocation());
        Assertions.assertEquals("type", error.getType());
    }
}