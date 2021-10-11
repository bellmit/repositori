package com.degloba.ecommerce.enviaments.webapp.controllers.impl.spring;

import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;

@ContextConfiguration(classes = SpringBootPersistenceApplication.class)
//@DataMongoTest
public class AfegirEnviament {
	
	 @Autowired
	static
	    ReactiveMongoTemplate template;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		template.save(new Enviament("2", "2", "4")).subscribe(); 

		 
	}

}
