package com.example.eventpublishing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class CustomSpringEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;
    private static final Logger log = LoggerFactory.getLogger(CustomSpringEventPublisher.class);

    public CustomSpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(String message){
        log.warn("publishing");
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
