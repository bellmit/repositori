package com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;


//https://stackoverflow.com/questions/51221777/failed-to-configure-a-datasource-url-attribute-is-not-specified-and-no-embedd/54892724
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })  
public class Spring5ReactiveApplication{

    public static void main(String[] args) {
        SpringApplication.run(Spring5ReactiveApplication.class, args);
    }

	/*
	 * @Autowired MongoClient mongoClient;
	 * 
	 * @Bean public ReactiveMongoTemplate reactiveMongoTemplate() { return new
	 * ReactiveMongoTemplate(mongoClient, "test"); }
	 */
}
