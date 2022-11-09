package com.brscrt.errorhandler.config;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ErrorConfigTest {

    @Test
    void givenNewConfig_whenCheckDefaultFields_thenFieldsAreCorrect() {
        //given
        ErrorConfig config = new ErrorConfig();

        //when, then
        Assertions.assertFalse(config.isEnabled());
    }

    @Test
    void givenNewConfig_whenCheckAllFields_thenFieldsAreCorrect() {
        //given
        ErrorConfig config = new ErrorConfig();
        config.setEnabled(true);

        //when, then
        Assertions.assertTrue(config.isEnabled());
    }
}