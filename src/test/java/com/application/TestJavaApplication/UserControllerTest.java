package com.application.TestJavaApplication;

import  org.junit.jupiter.api.Assertions;

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

import com.application.TestJavaApplication.models.UserModel;

import com.application.TestJavaApplication.repositories.UserRepository;

@ExtendWith(value = { SpringExtension.class })
@WebMvcTest
public class UserControllerTest {
	
	@Autowired
	UserRepository userRepos;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void contextLoads() throws Exception{
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/api/users")
					.accept(MediaType.APPLICATION_JSON)).andReturn();
		
		Mockito.verify(userRepos).findAll();
	}
	
	public void userCreate() {
		UserModel user = new UserModel();
		user.setUserid(4L);
		user.setName("Phil");
		
		userRepos.save(user);
		Assertions.assertNotNull(userRepos.findById(4L).get());
	}
	
	public void userDelete() {
		UserModel user = new UserModel();
		user.setUserid(5L);
		user.setName("User Delete");
		userRepos.save(user);	
		userRepos.delete(user);
		Assertions.assertNull(userRepos.findById(5L).get());
	}
	
	public void userUpdate() {
		UserModel user = new UserModel();
		user.setUserid(5L);
		user.setName("User");
		user.setEmail("test@email.com");
		userRepos.save(user);
		UserModel updatedUser = userRepos.findById(1L).get();
		updatedUser.setName("John");
		userRepos.save(updatedUser);
		Assertions.assertNotEquals("User", userRepos.findById(1L).get().getName());
	}
}
