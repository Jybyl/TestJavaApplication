package com.application.TestJavaApplication.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.application.TestJavaApplication.models.UserModel;
import com.application.TestJavaApplication.repositories.UserRepository;
@Configuration
public class UserConfig {

	@Bean
	CommandLineRunner userCommandLineRunner(UserRepository userRepository) {
		return args -> {
			UserModel user1 = new UserModel(
					"Test",
					"something@email.com"
				);
			UserModel user2 = new UserModel(
					"Test2",
					"someone@email.com"
				);
			
			userRepository.saveAll(
					List.of(user1, user2)
					);
		};
		
	}
}
