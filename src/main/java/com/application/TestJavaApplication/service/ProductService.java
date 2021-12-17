package com.application.TestJavaApplication.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.TestJavaApplication.models.ProductModel;
import com.application.TestJavaApplication.repositories.ProductRepository;

import lombok.NoArgsConstructor;


@Service
public class ProductService {

private ProductRepository productRepository;
	

	@Autowired
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	
	public List<ProductModel> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public void saveProduct(ProductModel product) {
		 
		Optional<ProductModel> productOptional =  productRepository.findProductByProductName(product.getProductName());
		if(productOptional.isPresent()) {
			throw new IllegalStateException("Product Name exists");
		}
		productRepository.save(product);
		System.out.println(product);
		
	}
	public ProductModel getProductById(long productId) {
		// TODO Auto-generated method stub
		Optional<ProductModel> product = productRepository.findById(productId);
		if(product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}

	@Transactional
	public void updateProduct(String productName, long productId) {
		ProductModel productModel = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException("product Id: " + productId + " does not exist"));
		
		if(productName != null && productName.length() > 0 && !Objects.equals(productModel.getProductName(), productName)){
			productModel.setProductName(productName);
		}
	}


	public void deleteProduct(long productId) {
		// TODO Auto-generated method stub
		if(productRepository.findById(productId).isPresent()) {
			productRepository.deleteById(productId);
		}
		else {
			throw new IllegalStateException("This product doesn't exist " + productId);
		}
	}


	

	
}
