package com.application.TestJavaApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.TestJavaApplication.models.ProductModel;
import com.application.TestJavaApplication.service.ProductService;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping
	public List<ProductModel> getProducts(){
		return productService.getAllProducts();
	}
	@PostMapping
	public void addProduct(@RequestBody ProductModel product){
		productService.saveProduct(product);
	}
	@DeleteMapping(path = "{productId}")
	public void deleteProduct(@PathVariable("productId") Long id) {
		productService.deleteProduct(id);
	}
	
	@PutMapping(path = "{productId}")
	public void updateProduct(@PathVariable("productId") Long id, @RequestParam(required = false) String productName) {
		productService.updateProduct(productName, id);
	}
}
