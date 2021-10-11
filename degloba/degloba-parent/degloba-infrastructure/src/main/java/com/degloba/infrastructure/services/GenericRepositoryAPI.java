package com.degloba.infrastructure.services;

import java.io.Serializable;

import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface GenericRepositoryAPI<T, ID extends Serializable> {

	Flux<T> findAllById(Iterable<String> ids);

	Flux<T> findAll();

	Mono<T> findById(Publisher<String> id);

	Mono<Boolean> existsById(Publisher<String> id);

	Flux<T> findAllById(Publisher<String> idStream);

	Mono<Void> deleteById(String id);

	Mono<Long> count();

	Mono<Void> deleteById(Publisher<String> id);

	Mono<Void> delete(T entity);

	Mono<Void> deleteAll(Iterable<? extends T> entities);

	Mono<Void> deleteAll(Publisher<? extends T> entityStream);

	<S extends T> Mono<S> findOne(Example<S> example);

	Mono<Void> deleteAll();

	<S extends T> Mono<Boolean> exists(Example<S> example);

	Mono<Void> deleteAllById(Iterable<? extends String> ids);

	<S extends T> Mono<Long> count(Example<S> example);

	Mono<Boolean> existsById(String id);

	<S extends T> Flux<S> saveAll(Publisher<S> entityStream);

	<S extends T> Flux<S> saveAll(Iterable<S> entities);

	Mono<T> findById(String id);

	<S extends T> Mono<S> save(S entity);

	Flux<T> findAll(Sort sort);

	<S extends T> Flux<S> findAll(Example<S> example, Sort sort);

	<S extends T> Flux<S> insert(Iterable<S> entities);

	<S extends T> Mono<S> insert(S entity);

	<S extends T> Flux<S> insert(Publisher<S> entities);

	<S extends T> Flux<S> findAll(Example<S> example);
	

		
}
