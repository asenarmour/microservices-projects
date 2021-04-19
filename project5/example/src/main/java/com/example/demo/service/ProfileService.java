package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepository;

@Service
public class ProfileService {
	

	@Autowired
	ProfileRepository profileRepo;
	
	@Autowired
	ContactUsService contactUsService;
	
	
	@Transactional
	public Profile saveProfile(Profile profile) {
		
		profile.getDetails().setId(profile.getId());
		profile.getDetails().setProfile(profile);
		if(profile.getContactUs()!=null) {
			contactUsService.saveContactUs(profile.getContactUs());
		}
		
		return profileRepo.save(profile);
	}


	public Optional<Profile> getProfile(Long id) {
		return profileRepo.findById(id);
	}
	
}
