package com.sparta.skilled_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Skilled3Application {

	public static void main(String[] args) {
		SpringApplication.run(Skilled3Application.class, args);
	}

}
