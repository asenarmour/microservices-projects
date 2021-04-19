package com.anurag.rupine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.rupine.model.Login;
import com.anurag.rupine.model.Users;
import com.anurag.rupine.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public String registor(@RequestBody Users user) throws Exception {
		 try {
			 userService.registerNewUserAccount(user);
			 return "success";
		 }
		 catch(Exception e) {
			 return ""+e;
		 }
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Login login) {
		if(userService.login(login))
			return "success";
		else 
			return "failure";
	}
	
	@GetMapping("/user/{email}")
	public Users getUser(@PathVariable String email) {
		return userService.getUser(email);
	}
}
