package com.degloba.ecommerce.configsevice.configs;

import java.util.Properties;

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
public class SubConfigMail {
	
	/**
	 * 
	 */
	private String host;
	
	private String password;
	
	private String userName;
	
	private String port;
	
	private String protocol;
	
	private String brokerUrl;
	
	private String brokerUserName;
	
	private String brokerPassword;
		
    
    
	/*
	 * props.put("mail.smtps.auth", true + "");
	 * props.put("mail.smtps.starttls.enable", true + "");
	 * props.put("mail.smtp.starttls.enable", true + "");
	 * 
	 * emailHost = environment.getProperty("notifications.email.host"); emailPort =
	 * Integer.parseInt(environment.getProperty("notifications.email.port"));
	 * emailProtocol = environment.getProperty("notifications.email.protocol");
	 * emailPassword = environment.getProperty("notifications.email.password");
	 * emailUsername = environment.getProperty("notifications.email.username");
	 * brokerUrl = environment.getProperty("broker.url"); username =
	 * environment.getProperty("broker.username"); password =
	 * environment.getProperty("broker.password"); notificationQueueName =
	 * environment.getProperty("amqp.notification.queue");
	 */
	
}

