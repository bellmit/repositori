package com.degloba.ecommerce.adminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class EcommerceAdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceAdminServiceApplication.class, args);
	}

}
