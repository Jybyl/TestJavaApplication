package com.application.TestJavaApplication.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.TestJavaApplication.models.OrderModel;
import com.application.TestJavaApplication.models.ProductModel;
import com.application.TestJavaApplication.service.OrderService;

@RestController
@RequestMapping(path = "api/orders")
public class OrderController {
	
	private OrderService orderService;
	
	
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}


	@GetMapping
	public  List<OrderModel> getOrders(){
		return orderService.getAllOrders(); 
	}
	@PostMapping
	public void addOrder(@RequestBody OrderModel order){
		
		orderService.saveOrder(order);
	}
	
	@PutMapping("{orderId}")
	public void updateOrder(@RequestBody Collection<ProductModel> updatedProducts, @PathVariable Long orderId) {
		
		orderService.updateOrder( orderId, updatedProducts);
	}
	
	@DeleteMapping("{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		orderService.deleteOrder(orderId);
	}
}
