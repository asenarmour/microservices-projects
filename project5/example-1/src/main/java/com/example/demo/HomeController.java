package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
public class HomeController {

	@Autowired
	HomeRepo repo;
	
	@PostMapping("/")
	public Employee Posten(@RequestBody Employee employee) {
		return repo.save(employee);
	}
}
