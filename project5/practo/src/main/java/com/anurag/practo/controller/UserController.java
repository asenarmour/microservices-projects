package com.anurag.practo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.practo.model.LoginRequest;
import com.anurag.practo.model.User;
import com.anurag.practo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repo;
	
	@PostMapping("/registor")
	public void registor(@RequestBody User user) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
	}
	
	@GetMapping("/welcome")
	public String home() {
		return "welcome to my Website";
	}
	
	@GetMapping("/login")
	public String login(@RequestBody LoginRequest login) {
		return "/welcome";
	}
}
