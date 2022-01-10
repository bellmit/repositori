package com.degloba.ecommerce.config.configs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Configura totes les propietats relacionades amb el client Google
 * 
 * @author pere
 *
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class SubConfigGoogle {
	
	/**
	 * 
	 */
	private String id;   // google.client.id = 910109996901-910v5uqubvse82fu2vqrblck9nhnhocb.apps.googleusercontent.com
	
	private String secret;   // client.secret=p1Fc6moFKqvD-XSU9J4U04tS
	
	private String userAuthorizationUri;   // https://accounts.google.com/o/oauth2/auth
			
	
}

