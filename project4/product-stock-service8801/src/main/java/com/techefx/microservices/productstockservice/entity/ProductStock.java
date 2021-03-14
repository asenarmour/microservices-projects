package com.techefx.microservices.productstockservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductStock {

	@Id
	private Long id;
	
	
	public ProductStock() {
	}
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private BigDecimal productPrice;
	
	@Column(name="product_availablity")
	private String productAvailablity;
	
	@Column(name="product_discountoffer")
	private double discountOffer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductAvailablity() {
		return productAvailablity;
	}
	public void setProductAvailablity(String productAvailablity) {
		this.productAvailablity = productAvailablity;
	}
	public double getDiscountOffer() {
		return discountOffer;
	}
	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}
	public ProductStock(Long id, String productName, BigDecimal productPrice, String productAvailablity,
			double discountOffer) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productAvailablity = productAvailablity;
		this.discountOffer = discountOffer;
	}
	
	
}
