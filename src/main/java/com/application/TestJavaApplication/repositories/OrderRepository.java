package com.application.TestJavaApplication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.TestJavaApplication.models.OrderModel;
@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long>{
	
	
}
