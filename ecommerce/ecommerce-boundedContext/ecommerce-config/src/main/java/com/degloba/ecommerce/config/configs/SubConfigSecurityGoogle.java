package com.degloba.ecommerce.config.configs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Configura totes les propietats relacionades amb Security Oauth Google
 * 
 * @author pere
 *
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class SubConfigSecurityGoogle {
	
	/**
	 * 
	 */
	private String code;   // authorization.code=authorization_code
	
	private String accessTokenUri;   // https://accounts.google.com/o/oauth2/token
	
	private String userAuthorizationUri;   // https://accounts.google.com/o/oauth2/auth
	
	private String scope;  // auth.scope=https://www.googleapis.com/auth/userinfo.email,https://www.googleapis.com/auth/userinfo.profile
	
	
	///google.preestablished.redirect.url=http://localhost:8888/googleLogin
	
}

