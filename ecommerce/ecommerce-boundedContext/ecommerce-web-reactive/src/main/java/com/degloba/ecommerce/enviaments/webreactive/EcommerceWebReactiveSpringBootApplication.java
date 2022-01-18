package com.degloba.ecommerce.enviaments.webreactive;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.degloba.ecommerce.enviaments.webreactive.config.RibbonConfiguration;

/**
 * 
 * @author degloba
 * 
 * @category test per provar un {@link org.springframework.web.reactive.function.client.WebClient}
 * 
 * @EnableEurekaClient = si volem accedir al servei "Discovery" de Eureka
 * @EnableDiscoveryClient = si volem accedir al servei "Discovery" en el contexte Kubernetes (ServiceDiscovery interface in Kubernetes)
 * 
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@EnableEurekaClient    o bé aquest o el seguent
@EnableDiscoveryClient    
@RibbonClient(name = "ecommerce-webapp", configuration = RibbonConfiguration.class)
public class EcommerceWebReactiveSpringBootApplication {

	   public static void main(String[] args) {
	       		   
	        SpringApplication.run(EcommerceWebReactiveSpringBootApplication.class, args);

			/*
			 * EnviamentWebClient enviamentWebClient = new EnviamentWebClient();
			 * enviamentWebClient.consume();
			 */
	    }
	   
//	   @Bean
//		public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//			return args -> {
//
//				System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//				String[] beanNames = ctx.getBeanDefinitionNames();
//				Arrays.sort(beanNames);
//				for (String beanName : beanNames) {
//					System.out.println(beanName);
//				}
//
//			};
//		}
}
