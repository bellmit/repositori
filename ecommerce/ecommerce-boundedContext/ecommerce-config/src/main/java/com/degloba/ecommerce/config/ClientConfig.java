package com.degloba.ecommerce.config;


import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "myconfig")   // mirar: ecommerce-config-configmap.yaml
@Data @AllArgsConstructor @NoArgsConstructor
public class ClientConfig {
			
	private String database;
	private SubConfigMongo subconfigMongo;
	private Map<String, String> subconfig2;

    // getters and setters
}

