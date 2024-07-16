package com.maxencew.biblioto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.maxencew.biblioto.infrastructure")
@SpringBootApplication
public class BibliotechApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotechApplication.class, args);
	}

}