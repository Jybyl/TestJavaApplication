package com.application.TestJavaApplication.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.application.TestJavaApplication.models.OrderModel;
import com.application.TestJavaApplication.models.ProductModel;
import com.application.TestJavaApplication.repositories.OrderRepository;
import com.application.TestJavaApplication.repositories.ProductRepository;
@Configuration
public class OrderConfig {

	@Bean
	CommandLineRunner orderCommandLineRunner(OrderRepository orderRepository) {
		return args -> {
			OrderModel order1 = new OrderModel(
					1L,
					1L,
				List.of(new ProductModel(5, "Product5"))
			);
		
			
		orderRepository.saveAll(
				List.of(order1)
					);
		};
		
	}
}
