package com.degloba.ecommerce.cqrs.enviaments;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 
 * @author pere
 *
 */
///@EnableAxon  Deprecated
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EcommerceWebappSpringBootApplication {

    public static void main(String ... args) {
        SpringApplication.run(EcommerceWebappSpringBootApplication.class, args);
    }
   

}