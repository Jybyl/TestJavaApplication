package com.application.TestJavaApplication.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	
	@Column(name = "email", nullable = false)
	private String email;


	public UserModel(long userid, String name, String email) {
		this.userid = userid;
		this.name = name;
		this.email = email;
	}


	public UserModel(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
}
