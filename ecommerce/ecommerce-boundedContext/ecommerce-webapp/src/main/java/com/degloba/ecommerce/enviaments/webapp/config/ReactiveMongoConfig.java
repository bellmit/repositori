package com.degloba.ecommerce.enviaments.webapp.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Config class to set up necessary components for watching the MongoDB change stream
 */
@Configuration
@EnableReactiveMongoRepositories
public class ReactiveMongoConfig extends AbstractReactiveMongoConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Bean
    public String getDatabaseName() {
        return "fantasy_db";
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }
}
