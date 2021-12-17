package com.application.TestJavaApplication.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.TestJavaApplication.models.ProductModel;
import com.application.TestJavaApplication.models.UserModel;
import com.application.TestJavaApplication.repositories.UserRepository;
@Service
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void saveUser(UserModel user) {
		// TODO Auto-generated method stub
		Optional<UserModel> userOptional =  userRepository.findUserByName(user.getName());
		if(userOptional.isPresent()) {
			throw new IllegalStateException("User Name exists");
		}
		userRepository.save(user);
		
	}

	
	public List<UserModel> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	
	public UserModel getUserById(long userId) {
		Optional<UserModel> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}

	@Transactional
	public void updateUser(String name, String email, long userId) {
		UserModel userModel = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("userId: " + userId + " does not exist"));
		
		if(name != null && name.length() > 0 && !Objects.equals(userModel.getName(), name)){
			userModel.setName(name);
		}
		if(email != null && email.length() > 0 && !Objects.equals(userModel.getEmail(), email)){
			userModel.setEmail(email);
		}
		
	}
 
	
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		if(userRepository.findById(userId).isPresent()) {
			userRepository.deleteById(userId);
		}
		else {
			throw new IllegalStateException("This user doesn't exist " + userId);
		}
	}

}
