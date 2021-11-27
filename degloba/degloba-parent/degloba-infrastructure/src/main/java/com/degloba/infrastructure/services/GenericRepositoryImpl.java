package com.degloba.infrastructure.services;


import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import org.reactivestreams.Publisher;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveFindOperation;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.repository.query.*;
import org.springframework.data.util.StreamUtils;
import org.springframework.data.util.Streamable;
import org.springframework.util.Assert;


import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.data.util.Lazy;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.DeleteResult;

import org.springframework.data.mongodb.repository.support.*;


import com.degloba.domain.persistence.nosql.GenericRepositoryAPI;


import static org.springframework.data.mongodb.core.query.Criteria.*;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

/**
 * 
 * @author pere
 * 
 * https://github.com/spring-projects/spring-data-mongodb/blob/main/spring-data-mongodb/src/main/java/org/springframework/data/mongodb/repository/support/SimpleReactiveMongoRepository.java
 * 
 * https://github.com/PacktPublishing/Hands-On-Reactive-Programming-in-Spring-5/blob/master/chapter-07/section-09-rx-sync/src/main/java/org/rpis5/chapters/chapter_07/wrapped_sync/ReactiveCrudRepositoryAdapter.java
 *
 * @param <T>
 * @param <ID>
 * @param <I>
 */

@Service
public abstract class GenericRepositoryImpl<T, ID extends Serializable, I extends ReactiveMongoRepository<T, ID>> implements GenericRepositoryAPI<T, ID> {
/////public abstract class GenericRepositoryImpl<T, ID extends Serializable> implements GenericRepositoryAPI<T, ID> {
	
	 @Autowired
	 ReactiveMongoTemplate template;
	 
	 protected final I delegate = null;
	 protected final Scheduler scheduler = null;
	 
	 private final MongoEntityInformation<T, ID> entityInformation;
		private final ReactiveMongoOperations mongoOperations;
		
		
		public GenericRepositoryImpl(MongoEntityInformation<T, ID> entityInformation,
				ReactiveMongoOperations mongoOperations) {

			Assert.notNull(entityInformation, "EntityInformation must not be null!");
			Assert.notNull(mongoOperations, "MongoOperations must not be null!");

			this.entityInformation = entityInformation;
			this.mongoOperations = mongoOperations;
		}
		
	 

	@Override
	public <S extends T> Mono<S> insert(S entity) {
		return template.save(entity);		
	}

	@Override
	public <S extends T> Flux<S> insert(Iterable<S> entities) {
		return Flux.fromIterable(entities).flatMap(template::insert);	
	}
	

	@Override
	public <S extends T> Flux<S> insert(Publisher<S> entities) {
		return Flux.from(entities).flatMap(template::insert);	
	}
	
	
	@Override
	public <S extends T> Mono<S> save(S entity) {
		return Mono.just(entity).flatMap(template::save);
	}

	@Override
	public <S extends T> Flux<S> saveAll(Iterable<S> entities) {
		return Flux.fromIterable(entities).flatMap(template::save);	
	}

	@Override
	public <S extends T> Flux<S> saveAll(Publisher<S> entityStream) {
		return Flux.from(entityStream).flatMap(template::save);
	}
	
	@Override
	public <S extends T> Mono<Boolean> exists(Example<S> example) {
		return Mono.just(example).hasElement();
	}


//	@Override
//	public Mono<Long> count() {
//		Criteria criteria = Criteria.where("_id").exists(true);
//		return template.count(Query.query(criteria), getClass());		
//	}
	
//	@Override
//	public Mono<Long> count() {
//		return createQuery().count();
//	}
	
	/*
	 * @Override public <S extends T> Mono<Long> count(Example<S> example) { return
	 * Mono .fromCallable(delegate::count) .subscribeOn(scheduler); }
	 */
	
	@Override
	public Mono<Void> delete(T entity) {
		     return Mono
		         .<Void>fromRunnable(() -> delegate.delete(entity))
		         .subscribeOn(scheduler);		
	}


	@Override
	public Mono<Void> deleteAll(Iterable<? extends T> entities) {
	      return Mono
	    	         .<Void>fromRunnable(() -> delegate.deleteAll(entities))
	    	         .subscribeOn(scheduler);
	}
	
	
	@Override
	public Mono<Void> deleteAll(Publisher<? extends T> entityStream) {
	      return Flux.from(entityStream)
	    	         .flatMap(entity -> Mono
	    	            .fromRunnable(() -> delegate.delete(entity))
	    	            .subscribeOn(scheduler))
	    	         .then();
	}

	@Override
	public Mono<Void> deleteAll() {
	      return Mono
	    	         .<Void>fromRunnable(delegate::deleteAll)
	    	         .subscribeOn(scheduler);
	}

	@Override
	public <S extends T> Mono<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> Flux<S> findAll(Example<S> example) {

		Assert.notNull(example, "Example must not be null!");

		return findAll(example, Sort.unsorted());
	}
	
	protected Query getIdQuery(Object id) {
		return new Query(getIdCriteria(id));
	}

	private Criteria getIdCriteria(Object id) {
		return where(entityInformation.getIdAttribute()).is(id);
	}

	private Query getIdQuery(Iterable<? extends ID> ids) {
		return new Query(where(entityInformation.getIdAttribute()).in(toCollection(ids)));
	}

	private static <E> Collection<E> toCollection(Iterable<E> ids) {
		return ids instanceof Collection ? (Collection<E>) ids
				: StreamUtils.createStreamFromIterator(ids.iterator()).collect(Collectors.toList());
	}
	
	@Override
	public <S extends T> Flux<S> findAll(Example<S> example, Sort sort) {
		Assert.notNull(example, "Example must not be null!");

		return findAll(example, Sort.unsorted());
	}
	
	
	@Override
	public Mono<Void> deleteAllById(Iterable<? extends ID> ids) {

		Assert.notNull(ids, "The given Iterable of Id's must not be null!");

		return mongoOperations
				.remove(getIdQuery(ids), entityInformation.getJavaType(), entityInformation.getCollectionName()).then();
	}
	
	
//	private ReactiveFindOperation.TerminatingFind<T> createQuery() {
//		return createQuery(UnaryOperator.identity());
//	}
	
//	private ReactiveFindOperation.TerminatingFind<T> createQuery(UnaryOperator<Query> queryCustomizer) {
//
//		Query query = new Query(new Criteria().alike(getPredicate())) //
//				.collation(entityInformation.getCollation());
//
//		if (getSort().isSorted()) {
//			query.with(getSort());
//		}
//
//		if (!getFieldsToInclude().isEmpty()) {
//			query.fields().include(getFieldsToInclude().toArray(new String[0]));
//		}
//
//		query = queryCustomizer.apply(query);
//
//		return mongoOperations.query(getPredicate().getProbeType()).inCollection(entityInformation.getCollectionName())
//				.as(getResultType()).matching(query);
//	}
	


}
