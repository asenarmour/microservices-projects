package com.techefx.microservices.productenquiryservice.bean;

import java.math.BigDecimal;

public class ProductEnquiryBean {

	private Long id;
	private String productName;
	private BigDecimal productPrice;
	private String productAvailablity;
	private double discountOffer;
	
	private int unit;
	private double totalPrice;
	
	private int port;

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

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ProductEnquiryBean(Long id, String productName, BigDecimal productPrice, String productAvailablity,
			double discountOffer, int unit, double totalPrice, int port) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productAvailablity = productAvailablity;
		this.discountOffer = discountOffer;
		this.unit = unit;
		this.totalPrice = totalPrice;
		this.port = port;
	}

	@Override
	public String toString() {
		return "ProductEnquiryBean [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productAvailablity=" + productAvailablity + ", discountOffer=" + discountOffer + ", unit=" + unit
				+ ", totalPrice=" + totalPrice + ", port=" + port + "]";
	}
	
	
}
