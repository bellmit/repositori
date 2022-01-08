package com.degloba.ecommerce.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EcommerceGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceGatewayServiceApplication.class, args);
	}

}
