package com.example.actuatorservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello %s!";
    private static AtomicLong id = new AtomicLong();

    @GetMapping("/hello-world")
    public Greeting respond(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(id.incrementAndGet(), String.format(template, name));
    }

}
