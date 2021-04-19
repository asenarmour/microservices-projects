package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long activeTemplateId;
	private Long themeId;
	private String institutionName;
	
	@CreationTimestamp
	private Timestamp createdOn;
	
	@UpdateTimestamp
	private Timestamp updatedOn;
	
	@OneToOne(mappedBy = "profile", cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY, optional = false)
	private ProfileDetails details;
	
	@JsonManagedReference
	@OneToOne( cascade = CascadeType.ALL, orphanRemoval = true,mappedBy="profile")
	private ContactUs contactUs;
}
