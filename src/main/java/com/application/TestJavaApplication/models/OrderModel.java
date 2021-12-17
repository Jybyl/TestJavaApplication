package com.application.TestJavaApplication.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="user_orders")
public class OrderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@JoinColumn(name="userId", nullable = false)
	private long userId;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	Collection<ProductModel> productOrder = new ArrayList<>();

	public OrderModel(long orderId, long userId, Collection<ProductModel> productOrder) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productOrder = productOrder;
	}

	public OrderModel(long userId, Collection<ProductModel> productOrder) {
		super();
		this.userId = userId;
		this.productOrder = productOrder;
	}
	
	
}
