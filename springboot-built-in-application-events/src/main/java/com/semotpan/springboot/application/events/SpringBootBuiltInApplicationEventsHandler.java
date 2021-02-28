package com.semotpan.springboot.application.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class SpringBootBuiltInApplicationEventsHandler {

    @EventListener(classes = ContextRefreshedEvent.class)
    public void handle(ContextRefreshedEvent event) {
        log.info("--<< ContextRefreshedEvent raised");
        // do stuff...
    }

    @EventListener
    public void handle(ApplicationPreparedEvent event) {
        log.info("--<< ApplicationPreparedEvent raised");
        // do stuff...
    }

    @EventListener
    public void handle(ApplicationStartedEvent event) {
        log.info("--<< ApplicationStartedEvent raised");
        // do stuff...
    }

    @EventListener
    public void handleLivenessState(AvailabilityChangeEvent<LivenessState> event) {
        log.info("--<< AvailabilityChangeEvent {} raised", event.getState());
        // do stuff...
    }

    @EventListener
    public void handle(ApplicationReadyEvent event) {
        log.info("--<< ApplicationReadyEvent raised");
        // do stuff...
    }

    @EventListener
    public void handleReadinessState(AvailabilityChangeEvent<ReadinessState> event) {
        log.info("--<< AvailabilityChangeEvent {} raised", event.getState());
        // do stuff...
    }

    @EventListener
    public void handle(ApplicationFailedEvent event) {
        log.info("--<< ApplicationFailedEvent raised");
        // do stuff...
    }

    @EventListener
    public void handle(WebServerInitializedEvent event) {
        log.info("--<< WebServerInitializedEvent raised");
        // do stuff...
    }
}
