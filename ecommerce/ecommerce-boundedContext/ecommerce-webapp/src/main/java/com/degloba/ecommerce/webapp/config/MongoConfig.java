package com.degloba.ecommerce.webapp.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableMongoRepositories(basePackageClasses = {com.degloba.ecommerce.enviaments.infrastructure.persistence.nosql.mongo.EnviamentReactiveRepository.class})
@ConfigurationProperties(prefix = "bean")
public class MongoConfig  {
	//private static final Logger log = LoggerFactory.getLogger(MongoConfig.class);
	
    @Value("${spring.data.mongodb.host}")
    private String mongoHost;        	

    @Autowired
    private MongoMappingContext mongoMappingContext;

    @PostConstruct
    public void init() {
    	this.mongoMappingContext.setAutoIndexCreation(true);
    	log.info("Mongo AutoIndexCreation: {}", this.mongoMappingContext.isAutoIndexCreation());
    }
    
    @Bean
    public MongoClient mongoClient()  {
    	String myHost = System.getenv("MONGODB_HOST");		
		log.info("MONGODB_HOST="+myHost);
        if(myHost==null) {
        	return MongoClients.create();
        }
		return MongoClients.create("mongodb://"+ myHost);
    }	

    @Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
		return new DefaultServerCodecConfigurer();
	}
}


