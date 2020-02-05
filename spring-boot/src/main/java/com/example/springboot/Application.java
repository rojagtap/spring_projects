package com.example.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext ctx){
		return args -> {
			System.out.println("From Bean!");
			String[] beanNames = ctx.getBeanDefinitionNames();

			Arrays.sort(beanNames);

			for (String bean: beanNames){
				System.out.println(bean);
			}
		};
	}
}
