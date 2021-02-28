package com.semotpan.custom.application.events;

import java.time.Instant;

public interface DomainEvent {

    Instant issuedOn();

}
