package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ContactUs;
import com.example.demo.model.Phone;
import com.example.demo.model.Profile;
import com.example.demo.repository.ContactUsRepo;
import com.example.demo.repository.ContactUsRepository;

@Service
public class ContactUsService {

	@Autowired
	ContactUsRepository contactUsRepo;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	ContactUsRepo cRepo;
	
	@Transactional
	public ContactUs saveContactUs(ContactUs contactUs) {
		
//		List<ContactUs> ctUs=contactUsRepo.findAll();
//		for(ContactUs contact:ctUs) {
//			if(contact.getProfile().getId()==profileId) {
////				deleteContact(contact.getId());
//				contactUs.setId(contact.getProfile().getId());
//				
//			}
//		}
		List<Phone> ph=contactUs.getPhone();
		ph.forEach(p->p.setContact(contactUs));
//		Optional<Profile> pro=profileService.getProfile(contactUs.getProfile().getId());
//		if(pro!=null) {
//			Profile finalProfile =pro.get();
//			contactUs.setProfile(finalProfile);
//		}
		return contactUsRepo.save(contactUs);
	}
	
	public boolean checkProfileId(Long id) {
		List<ContactUs> ctUs=contactUsRepo.findAll();
		for(ContactUs contact:ctUs) {
			if(contact.getProfile().getId()==id)
				return true;
		}
		return false;
		
	}
	
	
	public Optional<ContactUs> getContactUs(Long id) {
		return contactUsRepo.findById(id);
	}
	
	@Transactional
	public void deleteContact(Long id) {
		contactUsRepo.deleteById(id);
	}

	
//	public ContactUs updateContacts(Long id,ContactUs contactUs,Long profileId) {
//		ContactUs cUs=new ContactUs(
//				id,
//				contactUs.getEmail(),
//				contactUs.getAddressLine1(),
//				contactUs.getPhone(),
//				contactUs.getProfile()
//				);
//		return saveContactUs(cUs,profileId);
//	}

	
}
