package com.prajil.learning.cicuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CicuitbreakerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(CicuitbreakerApplication.class, args);
		System.out.println("Cotext Active "+context.isActive());

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().rootUri("http://localhost:9090")
				.build();
	}
}
