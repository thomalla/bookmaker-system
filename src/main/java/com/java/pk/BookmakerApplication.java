package com.java.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class BookmakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmakerApplication.class, args);
	}


}
