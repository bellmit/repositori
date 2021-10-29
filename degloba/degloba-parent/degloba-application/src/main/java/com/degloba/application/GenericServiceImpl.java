package com.degloba.infrastructure.services;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

	
	@Override
	public Mono<T> Save(T Entity) {
		return getDao().save(Entity);
	}

	@Override
	public Mono<Void> delete(ID id) {
		return getDao().deleteById(id);		
	}

	@Override
	public Mono<T> get(ID id) {
		return getDao().findById(id);
	}

	@Override
	public Flux<T> getAll() {
		return getDao().findAll();
	}


}
