package com.degloba.application;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Servei reactiu
 * 
 * @author pere
 *
 * @param <T>
 * @param <ID>
 */
public interface GenericServiceAPI<T, ID extends Serializable> {
	
	Mono<T> Save(T Entity);
	Mono<Void> delete(ID id);
	Mono<T> get(ID id);
	Flux<T> getAll();
	
	ReactiveMongoRepository<T, ID> getDao();
		
}
