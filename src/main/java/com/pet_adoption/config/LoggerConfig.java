package com.pet_adoption.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {

    private static final Logger logger = LoggerFactory.getLogger(LoggerConfig.class);

    public LoggerConfig() {
        logger.info("Logger configuration initialized");
    }
}
