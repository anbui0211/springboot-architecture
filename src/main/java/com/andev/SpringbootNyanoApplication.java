package com.andev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootNyanoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootNyanoApplication.class, args);
	}

	@GetMapping("/ping")
	public String hello() {
		return "PONG";
	}
}
