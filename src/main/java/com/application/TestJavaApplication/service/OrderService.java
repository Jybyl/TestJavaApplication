package com.application.TestJavaApplication.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.application.TestJavaApplication.models.OrderModel;
import com.application.TestJavaApplication.models.ProductModel;
import com.application.TestJavaApplication.models.UserModel;
import com.application.TestJavaApplication.repositories.OrderRepository;

@Service
public class OrderService {

private OrderRepository orderRepository;

	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
		
	}


	public void saveOrder(OrderModel order) {
		Optional<OrderModel> orderOptional =  orderRepository.findById(order.getOrderId());
		if(orderOptional.isPresent()) {
			throw new IllegalStateException("Order Id exists");
		}
		orderRepository.save(order);
		
	}


	public List<OrderModel> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}


	public OrderModel getOrderById(long orderId) {
		// TODO Auto-generated method stub
		Optional<OrderModel> order = orderRepository.findById(orderId);
		if(order.isPresent()) {
			return order.get();
		}
		else {
			return null;
		}
	}

	@Transactional
	public void updateOrder(Long orderId, Collection<ProductModel> updatedProducts) {
		// TODO Auto-generated method stub
		OrderModel orderModel = orderRepository.findById(orderId).orElseThrow(() -> new IllegalStateException("orderId: " + orderId + " does not exist"));
		
		if(updatedProducts != null) {
			orderModel.setProductOrder(updatedProducts);
		}
		
		
	}

	public void deleteOrder(long orderId) {
		// TODO Auto-generated method stub
		if(orderRepository.findById(orderId).isPresent()) {
			orderRepository.deleteById(orderId);
		}
		else {
			throw new IllegalStateException("This order doesn't exist " + orderId);
		}

	}
}
