package com.docker.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootApplication {
	
	@GetMapping("/hello")
	public String getHello() {
		return "Tui là Nga nè";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
