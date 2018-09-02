package com.crowdynamics.sigfox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SigfoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigfoxApplication.class, args);
	}
}
