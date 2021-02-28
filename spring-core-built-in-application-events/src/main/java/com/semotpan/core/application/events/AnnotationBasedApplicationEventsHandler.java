package com.semotpan.core.application.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;

@Slf4j
public class AnnotationBasedApplicationEventsHandler {

    @EventListener(classes = ContextStartedEvent.class)
    public void handle(ContextStartedEvent event) {
      log.info("--<< ContextStartedEvent annotation based listener raised");
        // do stuff...
    }

    @EventListener(classes = ContextClosedEvent.class)
    public void handle() {
        log.info("--<< ContextClosedEvent annotation based listener raised");
        // do stuff...
    }

    @EventListener(classes = ContextRefreshedEvent.class)
    public void handle(ContextRefreshedEvent event) {
        log.info("--<< ContextRefreshedEvent annotation based listener raised");
        // do stuff...
    }

    @EventListener
    public void handle(ContextStoppedEvent event) {
        log.info("--<< ContextStoppedEvent annotation based listener raised");
        // do stuff...
    }
}
