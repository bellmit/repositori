package com.degloba.ecommerce.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EcommerceWebappSpringBootApplication {

    public static void main(String ... args) {
        SpringApplication.run(EcommerceWebappSpringBootApplication.class, args);
    }

}