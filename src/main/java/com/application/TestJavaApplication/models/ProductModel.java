package com.application.TestJavaApplication.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name="products")
public class ProductModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	
	@Column(name= "product_name", nullable = false)
	private String productName;

	public ProductModel(long productId, String productName) {
		this.productId = productId;
		this.productName = productName;
	}

	public ProductModel(String productName) {
		this.productName = productName;
	}
	
	
}
