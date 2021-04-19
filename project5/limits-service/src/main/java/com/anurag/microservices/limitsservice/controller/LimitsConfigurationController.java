package com.anurag.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.microservices.limitsservice.bean.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private LimitsConfiguration limits;
	
	@GetMapping("/limits")
	public LimitsConfiguration getLimits() {
		return new LimitsConfiguration(limits.getMaximum(),limits.getMinimum());
	}
}
