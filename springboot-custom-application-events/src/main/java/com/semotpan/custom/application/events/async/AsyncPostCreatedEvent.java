package com.semotpan.custom.application.events.async;

import com.semotpan.custom.application.events.DomainEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
@RequiredArgsConstructor
final class AsyncPostCreatedEvent implements DomainEvent {

    public final Instant issuedOn = Instant.now();
    public final String title;
    public final String payload;

    @Override
    public Instant issuedOn() {
        return issuedOn;
    }

}
