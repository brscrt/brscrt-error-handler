package com.brscrt.errorhandler.testutil;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class TestBase {

    @BeforeAll
    private void initialize() {
        setup();
    }

    @AfterAll
    private void tearDown() {
        Mockito.clearAllCaches();
        clean();
    }

    protected abstract void setup();

    protected abstract void clean();
}
