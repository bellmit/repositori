package com.degloba.ecommerce.config;


import java.io.Serializable;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author pere
 *
 */
@Configuration
@ConfigurationProperties(prefix = "myconfig")   // mirar: ecommerce-config-configmap.yaml
@Data @AllArgsConstructor @NoArgsConstructor
public class ClientConfig implements Serializable { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Mongo database
	 */
	private String database; 
	
	/**
	 * propietats que pengen de database
	 */
	private SubConfigMongo subconfigMongo;
	

    // getters and setters
	
	
}