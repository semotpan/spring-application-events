package com.semotpan.core.application.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

@Slf4j
public class ContextStartedEventHandler implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        log.info("--<< ContextStartedEvent raised");
        // do stuff...
    }
}
