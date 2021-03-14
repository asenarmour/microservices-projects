package com.techefx.microservices.techefxspringcloudapigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

	@Bean
	public RouteLocator getProxyRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r.path("/product-enquiry/**")
				.uri("http://localhost:8700")
				.id("stock-enquiry")
				).build();
	}
}
