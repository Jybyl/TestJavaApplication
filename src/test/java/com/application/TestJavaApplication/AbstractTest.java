package com.application.TestJavaApplication;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestJavaApplication.class)
@WebAppConfiguration
public  class AbstractTest extends OrderControllerTest{

	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
//	@Test
//	public void testOrders() throws Exception {
//		mvc.perform(get("/api/orders")).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(jsonPath("$.productName").value("emp1")).andExpect(jsonPath("$.orderId").value(1))
//				.andExpect(jsonPath("$.productId").value("1")).andExpect(jsonPath("$.userId").value(1));
//
//	}
}
