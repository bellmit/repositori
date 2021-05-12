package com.degloba.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://ard333.medium.com/centralized-configuration-spring-application-on-kubernetes-4fd9e1a31f35
 */
@RestController
public class TestHTTPService {

	@Autowired
	private ClientConfig config;
	
	@Value("${myconfig.properties1}")    // mirar: ecommerce-config-configmap.yaml
	private String properties1;

	@GetMapping("config-autoreload")
	public String configAutoReload() {
		return "myconfig.database: " + config.getDatabase() + "\n"+
				"myconfig.subconfigMongo.name: " + config.getSubconfigMongo().getName() + "\n"+
				"myconfig.subconfigMongo.url: " + config.getSubconfigMongo().getUrl() + "\n"			
		;
	}

	@GetMapping("config-value")
	public String configFromValue() {
		return "properties1: " + properties1 + "\n";
	}
}
