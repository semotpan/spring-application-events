package com.semotpan.custom.application.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public final class EventPublisher {

    private final ApplicationEventPublisher publisher;

    public void publish(DomainEvent event) {
        log.info("-->> Published {}", event);
        publisher.publishEvent(event);
    }
}
