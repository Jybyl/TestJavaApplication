package com.application.TestJavaApplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.application.TestJavaApplication.models.ProductModel;

import com.application.TestJavaApplication.repositories.ProductRepository;

@ExtendWith(value = { SpringExtension.class })
@WebMvcTest
public class ProductControllerTest{

	@Autowired
	ProductRepository productRepos;
	
	@Autowired
	MockMvc mvc;
	@Test
	public void contextLoads() throws Exception{
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/api/users")
					.accept(MediaType.APPLICATION_JSON)).andReturn();
		Mockito.verify(productRepos).findAll();
	}
	
	@Test
	public void productCreate() {
		ProductModel product = new ProductModel();
		product.setProductId(4L);
		product.setProductName("Product Name");
		
		productRepos.save(product);
		Assertions.assertNotNull(productRepos.findById(4L).get());
	}
	@Test
	public void productDelete() {
		ProductModel product = new ProductModel();
		product.setProductId(5L);
		product.setProductName("Product Delete");
		productRepos.save(product);	
		productRepos.delete(product);
		Assertions.assertNull(productRepos.findById(5L).get());
	}
	@Test
	public void updateProduct() {
		ProductModel product = new ProductModel();
		product.setProductId(5L);
		product.setProductName("Product");
		productRepos.save(product);
		ProductModel updateProduct = productRepos.findById(5L).get();
		updateProduct.setProductName("Updated");
		productRepos.save(updateProduct);
		Assertions.assertNotEquals("Product", productRepos.findById(5L).get().getProductName());
	}
	
	
//	@Override
//	@Before
//	public void setUp() {
//      super.setUp();
//	}
//
//	@Test
//	public void productLoads() throws Exception{
//		
//		String uri = "/api/products";
//		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//		      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//		   
//		   int status = mvcResult.getResponse().getStatus();
//		   assertEquals(200, status);
//		   String content = mvcResult.getResponse().getContentAsString();
//		   ProductModel[] productlist = super.mapFromJson(content, ProductModel[].class);
//		   assertTrue(productlist.length > 0);
//	}
//	
//	@Test
//	public void addProduct() throws Exception {
//	   String uri = "/api/products";
//	   ProductModel product = new ProductModel();
//	   product.setProductId(3);
//	   product.setProductName("Pepsi");
//	   
//	   String inputJson = super.mapToJson(product);
//	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//	   
//	   int status = mvcResult.getResponse().getStatus();
//	   assertEquals(201, status);
//	   String content = mvcResult.getResponse().getContentAsString();
//	   assertEquals(content, "Product is created successfully");
//	}
//	
//	@Test
//	public void updateProduct() throws Exception {
//	   String uri = "/api/products/2";
//	   ProductModel product = new ProductModel();
//	   product.setProductName("Coca Cola");
//	   
//	   String inputJson = super.mapToJson(product);
//	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//	   
//	   int status = mvcResult.getResponse().getStatus();
//	   assertEquals(200, status);
//	   String content = mvcResult.getResponse().getContentAsString();
//	   assertEquals(content, "Product is updated successsfully");
//	}
//	
//	@Test
//	   public void deleteProduct() throws Exception {
//	      String uri = "/api/products/2";
//	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//	      int status = mvcResult.getResponse().getStatus();
//	      assertEquals(200, status);
//	      String content = mvcResult.getResponse().getContentAsString();
//	      assertEquals(content, "Product is deleted successsfully");
//	   }
}
