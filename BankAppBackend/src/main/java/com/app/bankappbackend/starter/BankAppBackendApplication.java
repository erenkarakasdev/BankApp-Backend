package com.app.bankappbackend.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.app.bankappbackend")
@SpringBootApplication(scanBasePackages = "com.app.bankappbackend")
@ComponentScan(basePackages = "com.app.bankappbackend")
@EnableJpaRepositories(basePackages = "com.app.bankappbackend")
public class BankAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppBackendApplication.class, args);
	}

}
