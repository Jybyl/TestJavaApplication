package com.application.TestJavaApplication.controller;

import java.util.List;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.TestJavaApplication.models.UserModel;
import com.application.TestJavaApplication.service.UserService;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
	
	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/allUsers")
	public List<UserModel> getUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping
	public String userLogin(@AuthenticationPrincipal OAuth2User user) {
		String name = user.getAttribute("name");
		String email = user.getAttribute("email");
		UserModel newUser = new UserModel(name, email);
		System.out.println(name + " " + email);
		userService.saveUser(newUser);
		return name + " " + email;
	}
	@PostMapping
	public void addUser(@RequestBody UserModel user){
		userService.saveUser(user);
		
	}
	@DeleteMapping(path = "{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
	}
	
	@PutMapping(path = "{userId}")
	public void updateUser(@PathVariable("userId") Long userId, @RequestParam(required = false) String name, String email) {
		userService.updateUser(name, email, userId);
	}
	
}
