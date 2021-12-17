package com.application.TestJavaApplication;

import org.junit.jupiter.api.Assertions;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.application.TestJavaApplication.models.OrderModel;
import com.application.TestJavaApplication.models.ProductModel;
import com.application.TestJavaApplication.repositories.OrderRepository;




@SpringBootTest
@ExtendWith(value = { SpringExtension.class })
@WebMvcTest
public  class OrderControllerTest  {
	
	@Autowired
	OrderRepository orderRepos;
	@Autowired
	MockMvc mvc;
	@Test
	public void contextLoads() throws Exception{
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/api/users")
					.accept(MediaType.APPLICATION_JSON)).andReturn();
		
		Mockito.verify(orderRepos).findAll();
	}
	
	@Test
	public void orderCreate() {
		OrderModel order = new OrderModel();
		order.setOrderId(4L);
		order.setUserId(1L);
		order.setProductOrder(List.of(new ProductModel(1L, "productTest")));
		
		orderRepos.save(order);
		Assertions.assertNotNull(orderRepos.findById(4L).get());
	}
	@Test
	public void orderDelete() {
		OrderModel order = new OrderModel();
		order.setOrderId(5L);
		order.setUserId(1L);
		order.setProductOrder(List.of(new ProductModel(2L, "productDelete")));
		
		orderRepos.save(order);
		orderRepos.deleteById(5L);
		Assertions.assertNull(orderRepos.findById(5L).get());
	}
	
	@Test
	public void orderUpdate() {
		OrderModel order = new OrderModel();
		order.setOrderId(1L);
		order.setUserId(1L);
		order.setProductOrder(List.of(new ProductModel(2L, "updatedProductOrder")));
		orderRepos.save(order);
		Assertions.assertNotEquals(new ProductModel(2L,"product"), orderRepos.findById(1L).get().getProductOrder());
	}
	
	
}
