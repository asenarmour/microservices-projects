package com.example.demo.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ContactUs;
import com.example.demo.model.Profile;
import com.example.demo.service.ContactUsService;

@RestController
public class ContactUsController {

	@Autowired
	ContactUsService contactUsService;

	@PostMapping("/profile/{profileId}/contact")
	public ContactUs saveContactUs(@RequestBody ContactUs contactUs,@PathVariable Long profileId) {
		return contactUsService.saveContactUs(contactUs);
	}
	
	@GetMapping("/contact-us/{id}")
	public Optional<ContactUs> getContactUs(@PathVariable Long id) {
		return contactUsService.getContactUs(id);
	}
	
	@DeleteMapping("/contact-us/{id}")
	public void deleteContact(@PathVariable Long id) {
		contactUsService.deleteContact(id);
	}
	
	
//	@Transactional
//	@PutMapping("/profile/{profileId}/contact/{id}")
//	public ContactUs updateContact(@RequestBody ContactUs contactUs,@PathVariable Long id,@PathVariable Long profileId) throws IllegalAccessException, InvocationTargetException {
//		Optional<ContactUs> contactUs1=contactUsService.getContactUs(id);
//		if(contactUs1!=null) 
//			return contactUsService.updateContacts(id,contactUs,profileId);
//		else
//			return null;
//	}
	
	
}
