package com.semotpan.core.application.events;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(Config.class)
class ApplicationCoreEventsTest {

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @Test
    void loadingEvents() {
        applicationContext.start();
        applicationContext.stop();
    }

}