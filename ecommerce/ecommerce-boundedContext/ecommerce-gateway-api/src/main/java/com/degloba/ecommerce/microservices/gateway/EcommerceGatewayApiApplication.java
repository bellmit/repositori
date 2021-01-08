package com.degloba.ecommerce.microservices.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class EcommerceGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceGatewayApiApplication.class, args);
	}

}
