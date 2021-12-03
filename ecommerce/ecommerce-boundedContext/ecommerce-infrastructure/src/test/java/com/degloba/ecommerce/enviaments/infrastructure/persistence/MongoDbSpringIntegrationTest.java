package com.degloba.ecommerce.enviaments.infrastructure.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.degloba.ecommerce.EcommerceInfrastructureSpringBootApplication;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = EcommerceInfrastructureSpringBootApplication.class)
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class MongoDbSpringIntegrationTest {
	
	 @Autowired
	    ReactiveMongoTemplate template;
	
	
    @DisplayName("given object to save"
        + " when save object using MongoDB template"
        + " then object is saved")
    @Test
    public void test(@Autowired MongoTemplate mongoTemplate) {
        // given
        DBObject objectToSave = BasicDBObjectBuilder.start()
            .add("enviamentId", "2")
            .add("comandaId", "2")
            .add("estatEnviament", "3")
            .get();

        // when
        mongoTemplate.save(objectToSave, "collection");

        // then
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("enviamentId")
            .containsOnly("2");
    }
    
    
    @DisplayName("given object to save"
            + " when save object using MongoDB template"
            + " then object is saved")
        @Test
        public void test(@Autowired ReactiveMongoTemplate reactiveMongoTemplate) {
            // given
            DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("enviamentId", "2")
                .add("comandaId", "2")
                .add("estatEnviament", "3")
                .get();

            // when
            reactiveMongoTemplate.save(objectToSave, "collection").subscribe();

            // then
            //assertThat(reactiveMongoTemplate.findAll(DBObject.class, "collection")).extracting("enviamentId")
            //    .containsOnly("2");
        }
}