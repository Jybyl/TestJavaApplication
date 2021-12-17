package com.application.TestJavaApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	
//	@LocalServerPort
//	private int port;
//	
//	@Autowired
//	private TestRestTemplate template;
//	
//	@Test
//	public void defaultGreetingPage() throws Exception {
//		assertThat(this.template.getForObject("http://localhost:" + port + "/", String.class)).contains("Welcome!");
//	}
	

}
