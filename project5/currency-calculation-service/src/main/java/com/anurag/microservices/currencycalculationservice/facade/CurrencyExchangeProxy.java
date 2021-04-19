package com.anurag.microservices.currencycalculationservice.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.anurag.microservices.currencycalculationservice.model.CalculateAmount;

@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CalculateAmount retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);
}
