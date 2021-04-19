package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="profile_details")
public class ProfileDetails {

	@Id
	private Long id;
	
	private String aboutUs;
	private int noOfBed;
	private int icuBed;
	private boolean pathLab;
	private boolean trumaFacility;
	private boolean infectiousDiseaseFacility;
	private boolean psychiatricFacility;
	private boolean ambulanceFacility;
	private String websiteAddress;
	private String status;
	private String bannerUrl;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name="id")
	private Profile profile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	public int getNoOfBed() {
		return noOfBed;
	}

	public void setNoOfBed(int noOfBed) {
		this.noOfBed = noOfBed;
	}

	public int getIcuBed() {
		return icuBed;
	}

	public void setIcuBed(int icuBed) {
		this.icuBed = icuBed;
	}

	public boolean isPathLab() {
		return pathLab;
	}

	public void setPathLab(boolean pathLab) {
		this.pathLab = pathLab;
	}

	public boolean isTrumaFacility() {
		return trumaFacility;
	}

	public void setTrumaFacility(boolean trumaFacility) {
		this.trumaFacility = trumaFacility;
	}

	public boolean isInfectiousDiseaseFacility() {
		return infectiousDiseaseFacility;
	}

	public void setInfectiousDiseaseFacility(boolean infectiousDiseaseFacility) {
		this.infectiousDiseaseFacility = infectiousDiseaseFacility;
	}

	public boolean isPsychiatricFacility() {
		return psychiatricFacility;
	}

	public void setPsychiatricFacility(boolean psychiatricFacility) {
		this.psychiatricFacility = psychiatricFacility;
	}

	public boolean isAmbulanceFacility() {
		return ambulanceFacility;
	}

	public void setAmbulanceFacility(boolean ambulanceFacility) {
		this.ambulanceFacility = ambulanceFacility;
	}

	public String getWebsiteAddress() {
		return websiteAddress;
	}

	public void setWebsiteAddress(String websiteAddress) {
		this.websiteAddress = websiteAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public ProfileDetails(Long id, String aboutUs, int noOfBed, int icuBed, boolean pathLab, boolean trumaFacility,
			boolean infectiousDiseaseFacility, boolean psychiatricFacility, boolean ambulanceFacility,
			String websiteAddress, String status, String bannerUrl, Profile profile) {
		super();
		this.id = id;
		this.aboutUs = aboutUs;
		this.noOfBed = noOfBed;
		this.icuBed = icuBed;
		this.pathLab = pathLab;
		this.trumaFacility = trumaFacility;
		this.infectiousDiseaseFacility = infectiousDiseaseFacility;
		this.psychiatricFacility = psychiatricFacility;
		this.ambulanceFacility = ambulanceFacility;
		this.websiteAddress = websiteAddress;
		this.status = status;
		this.bannerUrl = bannerUrl;
		this.profile = profile;
	}

	public ProfileDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
