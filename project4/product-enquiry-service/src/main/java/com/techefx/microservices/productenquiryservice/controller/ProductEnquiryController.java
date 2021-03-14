package com.techefx.microservices.productenquiryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techefx.microservices.productenquiryservice.bean.ProductEnquiryBean;
import com.techefx.microservices.productenquiryservice.client.ProductStockClient;

@RestController
public class ProductEnquiryController {

	@Autowired
	ProductStockClient client;
	
	@GetMapping("/product-enquiry/name/{name}/availablity/{availablity}/unit/{unit}")
	public ProductEnquiryBean getEnquiryProduct(@PathVariable String name,@PathVariable String availablity,@PathVariable int unit) {
		ProductEnquiryBean productEnquiryBean=client.checkProductStock(name, availablity);
		double totalPrice=productEnquiryBean.getProductPrice().doubleValue()*unit;
		double discount=productEnquiryBean.getDiscountOffer();
		double discountPrice= totalPrice-totalPrice*discount/100;
		
		return new ProductEnquiryBean(
				productEnquiryBean.getId(),
				name,
				productEnquiryBean.getProductPrice(),
				availablity,
				productEnquiryBean.getDiscountOffer(),
				unit,
				discountPrice,
				productEnquiryBean.getPort()
				
				);
	}
}
