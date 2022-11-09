package com.brscrt.errorhandler.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("java:S1068")
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.error-handling")
public class ErrorConfig {
    private boolean enabled = false;
}
