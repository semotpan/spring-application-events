package com.semotpan.core.application.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

@Slf4j
public class ContextStoppedEventHandler implements ApplicationListener<ContextStoppedEvent> {

    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        log.info("--<< ContextStoppedEvent raised");
        // do stuff...
    }
}
