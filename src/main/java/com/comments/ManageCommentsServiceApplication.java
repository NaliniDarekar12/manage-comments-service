package com.comments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.comments.*")
public class ManageCommentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageCommentsServiceApplication.class, args);
	}

}
