package com.semotpan.custom.application.events.sync;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
final class SecondLogCreatedEvent {

    public final String log;

}
