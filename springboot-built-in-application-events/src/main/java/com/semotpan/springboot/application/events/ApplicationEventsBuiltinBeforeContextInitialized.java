package com.semotpan.springboot.application.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

class ApplicationEventsBuiltinBeforeContextInitialized {

    @Slf4j
    static class ApplicationStartingEventHandler implements ApplicationListener<ApplicationStartingEvent> {
        @Override
        public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
            log.info("--<< ApplicationStartingEvent raised");
            // do stuff...
        }
    }

    @Slf4j
    static class ApplicationEnvironmentPreparedEventHandler implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
            log.info("--<< ApplicationEnvironmentPreparedEvent raised");
            // do stuff...
        }
    }

    @Slf4j
    static class ApplicationContextInitializedEventHandler implements ApplicationListener<ApplicationContextInitializedEvent> {
        @Override
        public void onApplicationEvent(ApplicationContextInitializedEvent applicationContextInitializedEvent) {
            log.info("--<< ApplicationContextInitializedEvent raised");
            // do stuff...
        }
    }

    @Slf4j
    static class ApplicationPreparedEventHandler implements ApplicationListener<ApplicationPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
            log.info("--<< ApplicationPreparedEvent raised");
            // do stuff...
        }
    }
}
