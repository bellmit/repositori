package com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.ReactiveRemoveOperation;
import org.springframework.stereotype.Service;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EnviamentTemplateOperations {

	 @Autowired
	    ReactiveMongoTemplate template;

	    public Mono<Enviament> findById(String id) {
	        return template.findById(id, Enviament.class);
	    }

	    public Flux<Enviament> findAll() {
	        return template.findAll(Enviament.class);
	    }

	    public Mono<Enviament> save(Mono<Enviament> account) {
	        return template.save(account);
	    }

	    public ReactiveRemoveOperation.ReactiveRemove<Enviament> deleteAll() {
	        return template.remove(Enviament.class);
	    }
}
