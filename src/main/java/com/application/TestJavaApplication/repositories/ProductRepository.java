package com.application.TestJavaApplication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.TestJavaApplication.models.ProductModel;
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>{

	Optional<ProductModel> findProductByProductName(String productName);
	

		
}
