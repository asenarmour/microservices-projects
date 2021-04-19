package com.anurag.microservices.currencycalculationservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anurag.microservices.currencycalculationservice.facade.CurrencyExchangeProxy;
import com.anurag.microservices.currencycalculationservice.model.CalculateAmount;

@RestController
public class CurrencyCalculationController {

	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CalculateAmount calculateAmount(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		Map<String,String> uriVariables=new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to", to);
		ResponseEntity<CalculateAmount> responseEntity	=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CalculateAmount.class, uriVariables);
		CalculateAmount calculateAmount=responseEntity.getBody();
		return new CalculateAmount(calculateAmount.getId(),
				from,
				to,
				calculateAmount.getConversionMultiple(),
				quantity,
				quantity.multiply(calculateAmount.getConversionMultiple()),
				calculateAmount.getPort()
				);
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CalculateAmount calculateAmountFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		
		CalculateAmount calculateAmount=proxy.retrieveExchangeValue(from, to);
		return new CalculateAmount(calculateAmount.getId(),
				from,
				to,
				calculateAmount.getConversionMultiple(),
				quantity,
				quantity.multiply(calculateAmount.getConversionMultiple()),
				calculateAmount.getPort()
				);
	}
	
}
