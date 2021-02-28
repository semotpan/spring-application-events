package com.semotpan.custom.application.events.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class AsyncPostEventListener {

    @Async
    @EventListener
    public void handle(AsyncPostCreatedEvent event) {
        log.info("--<< Async event {}", event);
        // do stuff
    }
}
