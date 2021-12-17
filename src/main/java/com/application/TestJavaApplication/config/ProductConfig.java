package com.application.TestJavaApplication.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.application.TestJavaApplication.models.ProductModel;
import com.application.TestJavaApplication.repositories.ProductRepository;

@Configuration
public class ProductConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			ProductModel product1 = new ProductModel(
					"Test"
				);
			ProductModel product2 = new ProductModel(
					"Test2" 
				);
			
			productRepository.saveAll(
					List.of(product1, product2)
					);
		};
		
	}

}
