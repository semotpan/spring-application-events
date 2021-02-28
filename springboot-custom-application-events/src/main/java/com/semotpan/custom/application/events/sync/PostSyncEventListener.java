package com.semotpan.custom.application.events.sync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class PostSyncEventListener {

    @EventListener
    public void handle(SyncPostCreatedEvent event) {
        log.info("--<< Sync event {}", event);
        // do stuff
    }

    @EventListener(condition = "#event.status.name() == 'UPDATE'")
    public SecondLogCreatedEvent handleUpdate(SyncPostCreatedEvent event) {
        log.info("--<< UPDATE Sync event {}", event);
        // do stuff
        return new SecondLogCreatedEvent(event.payload);
    }

    @EventListener
    public void handle(SecondLogCreatedEvent event) {
        log.info("--<< Sync Second event {}", event);
        // do stuff
    }
}
