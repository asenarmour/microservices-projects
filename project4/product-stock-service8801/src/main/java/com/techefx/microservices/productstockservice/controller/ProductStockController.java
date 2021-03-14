package com.techefx.microservices.productstockservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techefx.microservices.productstockservice.bean.ProductStockBean;
import com.techefx.microservices.productstockservice.entity.ProductStock;
import com.techefx.microservices.productstockservice.entity.ProductStockRepository;

@RestController
public class ProductStockController {

	@Autowired
	Environment environment;
	
	
	@Autowired
	ProductStockRepository productStockRepo;
	
	@GetMapping("/check-product-stock/productName/{productName}/productAvailablity/{productAvailablity}")
	public ProductStockBean checkProductStock(@PathVariable String productName,@PathVariable String productAvailablity) {
		
		ProductStock productStock=productStockRepo.findByProductNameAndProductAvailablity(productName, productAvailablity);
		ProductStockBean productBean=new ProductStockBean(
				productStock.getId(),
				productStock.getProductName(),
				productStock.getProductPrice(),
				productStock.getProductAvailablity(),
				productStock.getDiscountOffer(),
				Integer.parseInt(environment.getProperty("local.server.port"))
				);
		return productBean;
	}
}
