package com.degloba.ecommerce.config.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Configura totes les propietats relacionades amb PostgresSQL
 * 
 * @author pere
 *
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class SubConfigPostgresSQL {
	
	/**
	 * Nom de la database
	 */
	private String name;
	
	/**
	 * ha d'apuntar al servei
	 */
	private String url; 
	
	private String host;
	
	private String port;
	
	private String username;
	
	private String password;
	
	private String driver;
	
	
}

