package com.example.eventpublishing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class CustomSpringEventListener{

    private static final Logger log = LoggerFactory.getLogger(CustomSpringEventPublisher.class);

    @EventListener
    public void onApplicationEvent(CustomSpringEvent customSpringEvent) {
        log.warn("Event: " + customSpringEvent.getMessage() + " listened.");
    }
}
