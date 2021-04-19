package com.anurag.rupine.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.rupine.model.Pharmacy;
import com.anurag.rupine.repository.PharmacyRepository;


@Service
public class PharmacyService {

	@Autowired
	private PharmacyRepository pharmacyRepo;
	
	public void save(Pharmacy pharmacy) {
		pharmacyRepo.save(pharmacy);
	}
	
	public Optional<Pharmacy> getPharmacy(Long id) {
	   return pharmacyRepo.findById(id);
	}
}
