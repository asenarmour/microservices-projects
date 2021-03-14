package com.techefx.microservices.productstockservice.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long>{

	ProductStock findByProductNameAndProductAvailablity(String productName, String productAvailability);
}
