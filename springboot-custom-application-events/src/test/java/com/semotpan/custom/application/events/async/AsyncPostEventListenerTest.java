package com.semotpan.custom.application.events.async;

import com.semotpan.custom.application.events.EventPublisher;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@SpringBootTest
@RecordApplicationEvents
@TestPropertySource("classpath:/application-test.properties")
class AsyncPostEventListenerTest {

    @Autowired
    EventPublisher eventPublisher;

    @Autowired
    ApplicationEvents applicationEvents;

    @Test
    void publishing() {
        var event = new AsyncPostCreatedEvent("Async Event 1", "Async Event Payload 1");
        eventPublisher.publish(event);

        await().atLeast(Duration.ofSeconds(1));

        assertThat(applicationEvents.stream(AsyncPostCreatedEvent.class))
                .extracting(
                        AsyncPostCreatedEvent::getTitle,
                        AsyncPostCreatedEvent::getPayload
                )
                .containsExactly(
                        Tuple.tuple(event.title, event.payload)
                );
    }
}
