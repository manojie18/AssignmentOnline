package com.example.easyship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EasyShipApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyShipApplication.class, args);
	}

}
