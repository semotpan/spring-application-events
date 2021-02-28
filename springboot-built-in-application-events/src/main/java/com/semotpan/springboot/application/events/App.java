package com.semotpan.springboot.application.events;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static com.semotpan.springboot.application.events.ApplicationEventsBuiltinBeforeContextInitialized.*;
import static org.springframework.boot.Banner.Mode.*;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(App.class)
                .bannerMode(OFF)
                .listeners(
                        new ApplicationStartingEventHandler(),
                        new ApplicationPreparedEventHandler(),
                        new ApplicationContextInitializedEventHandler(),
                        new ApplicationEnvironmentPreparedEventHandler())
                .run(args);
    }
}
