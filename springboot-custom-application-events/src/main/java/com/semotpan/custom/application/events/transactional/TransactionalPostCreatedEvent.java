package com.semotpan.custom.application.events.transactional;

import com.semotpan.custom.application.events.DomainEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
@RequiredArgsConstructor
final class TransactionalPostCreatedEvent implements DomainEvent {

    public final Instant issuedOn = Instant.now();
    public final String title;
    public final Integer postId;

    @Override
    public Instant issuedOn() {
        return issuedOn;
    }
}
