package com.semotpan.core.application.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

@Configuration
class Config {

    @Bean
    ApplicationListener<ContextClosedEvent> contextClosedEventHandler() {
        return new ContextClosedEventHandler();
    }

    @Bean
    ApplicationListener<ContextRefreshedEvent> contextRefreshedEventHandler() {
        return new ContextRefreshedEventHandler();
    }

    @Bean
    ApplicationListener<ContextStartedEvent> contextStartedEventHandler() {
        return new ContextStartedEventHandler();
    }

    @Bean
    ApplicationListener<ContextStoppedEvent> contextStoppedEventHandler() {
        return new ContextStoppedEventHandler();
    }

    @Bean
    AnnotationBasedApplicationEventsHandler annotationBasedApplicationEventsHandler() {
        return new AnnotationBasedApplicationEventsHandler();
    }
}
