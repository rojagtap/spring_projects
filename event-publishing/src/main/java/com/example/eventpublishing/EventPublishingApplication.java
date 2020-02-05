package com.example.eventpublishing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventPublishingApplication {

	private final CustomSpringEventPublisher publisher;

	public EventPublishingApplication(CustomSpringEventPublisher publisher) {
		this.publisher = publisher;
	}

	public static void main(String[] args) {
		SpringApplication.run(EventPublishingApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(){
		return args -> {
			publisher.publish("Hello!");
		};
	}

}
