package com.premsh.jpaexperiment.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class HomeController {
	
	@Value("${admin.username}")
	String username;
	@Value("${admin.password}")
	String password;
	
	@GetMapping
	public String ping() {
		return username+" "+password;
	}
	
	@GetMapping("/admin")
	public ResponseEntity<User> getAdmin(){
		return new ResponseEntity<User>(new User(username, password), HttpStatus.OK);
	}
	
}
class User{
	String username;
	String password;
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}