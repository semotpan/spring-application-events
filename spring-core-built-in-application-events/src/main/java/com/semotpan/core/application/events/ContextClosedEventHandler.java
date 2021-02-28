package com.semotpan.core.application.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@Slf4j
public class ContextClosedEventHandler implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        log.info("--<< ContextClosedEvent raised");
        // do stuff...
    }
}
