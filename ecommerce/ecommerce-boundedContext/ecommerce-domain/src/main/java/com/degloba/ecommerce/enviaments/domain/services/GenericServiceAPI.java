package com.degloba.ecommerce.enviaments.domain.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenericServiceAPI<T, ID extends Serializable> {
	
	Mono<T> Save(T Entity);
	void delete(ID id);
	Mono<T> get(ID id);
	Flux<T>  getAll();
	
	ReactiveMongoRepository<T, ID> getDao();
		
}
