package com.degloba.ecommerce.configsevice.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Configura totes les propietats relacionades amb Axon
 * 
 * @author pere
 *
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class SubConfigAxon {
	
	/**
	 * 
	 */
	private String queue;
	
	private String exchange;
	
	private String binding;
		
	
}

