package com.degloba.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://ard333.medium.com/centralized-configuration-spring-application-on-kubernetes-4fd9e1a31f35
 */
@RestController 
@RequestMapping("/")
public class TestHTTPService {

	@Autowired
	private ClientConfig config;
	
	/*
	 * @Value("${ecommerceConfig.database}") // mirar: ecommerce-config-configmap.yaml
	 * private String properties1;
	 */

	@GetMapping("config-autoreload")
	public String configAutoReload() {
		
		  return "ecommerceConfig.database: " + config.getDatabase() + "\n"+
		  "ecommerceConfig.subconfigMongo.name: " + config.getSubconfigMongo().getName() + "\n"+
		  "\n"+ "ecommerceConfig.subconfigMongo.url: " + config.getSubconfigMongo().getUrl() + "\n"+
		  "ecommerceConfig.subconfigMongo.name: " + config.getSubconfigMongo().getHost() + "\n"+
		  "\n"+ "ecommerceConfig.subconfigMongo.url: " + config.getSubconfigMongo().getPort() +		  
		  "\n" ;
	}

	/*
	 * @GetMapping("config-value") public String configFromValue() { return
	 * "properties1: " + properties1 + "\n"; }
	 */
}
