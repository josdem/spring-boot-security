package com.josdem.springboot.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class SecurityApplicationTests {

    private final ApplicationContext applicationContext;

    @Test
    @DisplayName("it loads application")
    void shouldLoadApplication(TestInfo testInfo) {
        log.info("Running: {}", testInfo.getDisplayName());
        assertNotNull(applicationContext, "application context should not be null");
    }
}
