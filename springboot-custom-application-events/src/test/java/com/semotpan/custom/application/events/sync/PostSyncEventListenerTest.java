package com.semotpan.custom.application.events.sync;

import com.semotpan.custom.application.events.EventPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import static com.semotpan.custom.application.events.sync.Status.UPDATE;
import static com.semotpan.custom.application.events.sync.Status.NEW;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@SpringBootTest
@RecordApplicationEvents
@TestPropertySource("classpath:/application-test.properties")
class PostSyncEventListenerTest {

    @Autowired
    EventPublisher eventPublisher;

    @Autowired
    ApplicationEvents applicationEvents;

    @Test
    void publishing() {
        var event = new SyncPostCreatedEvent("Sync Title", "Sync Payload", NEW);
        eventPublisher.publish(event);

        assertThat(applicationEvents.stream(SyncPostCreatedEvent.class))
                .extracting(
                        SyncPostCreatedEvent::getTitle,
                        SyncPostCreatedEvent::getPayload,
                        SyncPostCreatedEvent::getStatus
                )
                .containsExactly(
                        tuple(event.title, event.payload, NEW)
                );
    }

    @Test
    void publishingConditional() {
        var event = new SyncPostCreatedEvent("Sync Conditional Title", "Sync Conditional Payload", UPDATE);
        eventPublisher.publish(event);

        assertThat(applicationEvents.stream(SyncPostCreatedEvent.class))
                .extracting(
                        SyncPostCreatedEvent::getTitle,
                        SyncPostCreatedEvent::getPayload,
                        SyncPostCreatedEvent::getStatus
                )
                .containsExactly(
                        tuple(event.title, event.payload, UPDATE)
                );
    }
}