package com.degloba.ecommerce.configservice;


import java.io.Serializable;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.degloba.ecommerce.configsevice.configs.SubConfigMongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author pere
 * 
 * Object Mapping for Configuration in ConfigMap
 * https://ard333.medium.com/centralized-configuration-spring-application-on-kubernetes-4fd9e1a31f35
 *
 */
@Configuration
@ConfigurationProperties(prefix = "ecommerceconfig")   // mirar: ecommerce-config-configmap.yaml
@Data @AllArgsConstructor @NoArgsConstructor
public class ClientConfig implements Serializable { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Mongo database
	 */
	private String database = "fantasy_db";    // nom de la BBDD
	
	/**
	 * propietats que pengen de database
	 */
	private SubConfigMongo subconfigMongo;
	

    // getters and setters
	
	
}