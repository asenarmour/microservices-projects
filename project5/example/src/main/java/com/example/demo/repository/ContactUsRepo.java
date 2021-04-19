package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ContactUsRepo {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void deleteContact(Long id) {
		entityManager.createQuery("delete c from ContactUs c where c.id=:id").setParameter("id", id);
	}
}
