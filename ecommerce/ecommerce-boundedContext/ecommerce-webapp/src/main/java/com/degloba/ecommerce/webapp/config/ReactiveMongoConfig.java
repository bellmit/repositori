package com.degloba.ecommerce.webapp.config;

/////import com.degloba.ecommerce.configservice.ClientConfig;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import lombok.NonNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;
import com.degloba.ecommerce.enviaments.infrastructure.persistence.nosql.mongo.EnviamentMongoEntityInformation;
import com.degloba.ecommerce.enviaments.infrastructure.persistence.nosql.mongo.PersistableMongoEntityInformation;

import com.degloba.ecommerce.enviaments.infrastructure.persistence.nosql.mongo.EnviamentReactiveRepository;

/**
 * Configuració MongoDb reactiu
 */
@Configuration
@EnableReactiveMongoRepositories
@ConfigurationProperties(prefix = "ecommerceconfig")  // mirar ecommerce-config-service
public class ReactiveMongoConfig extends AbstractReactiveMongoConfiguration {
	
	
//	@Autowired
//	private ClientConfig config; // per accedir a les propietats a partir d'una "configuracio centralitzada"


	
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
        /////return config.getDatabase();     /////"fantasy_db";  // cal recuperar del servei : ecommerce_config-service
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }
        
    
	@Bean
	public MongoEntityInformation<Enviament, String> mongoEntityInformation() {
	    return new EnviamentMongoEntityInformation();
	    //return new PersistableMongoEntityInformation();
	}
   
    
}
