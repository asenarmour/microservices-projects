package com.techefx.microservices.productenquiryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techefx.microservices.productenquiryservice.bean.ProductEnquiryBean;

@FeignClient(name="techefx-product-stock-service")
public interface ProductStockClient {

	@GetMapping("/check-product-stock/productName/{productName}/productAvailablity/{productAvailablity}")
	public ProductEnquiryBean checkProductStock(@PathVariable String productName,@PathVariable String productAvailablity);
}
