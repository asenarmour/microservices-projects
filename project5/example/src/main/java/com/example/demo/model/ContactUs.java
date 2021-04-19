package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="inst_contact_us")
public class ContactUs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	@Column(name="address_line1")
	private String addressLine1;

	@JsonManagedReference
	@OneToMany( cascade = CascadeType.REMOVE, orphanRemoval = true,mappedBy="contact")
	private List<Phone> phone;

	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="profile_id")
	private Profile profile;


	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public ContactUs(Long id, String email, String addressLine1, List<Phone> phone, Profile profile) {
		super();
		this.id = id;
		this.email = email;
		this.addressLine1 = addressLine1;
		this.phone = phone;
		this.profile = profile;
	}

	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
