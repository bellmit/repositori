package com.degloba.ecommerce.configservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;



@SpringBootApplication
@EnableConfigServer   // defineix un Config Server en l'entorn Spring Cloud.Podriem definir un Config Server en Kubernetes (ConfigMapS, SecretS)
public class EcommerceConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceConfigServiceApplication.class, args);
	}

}
