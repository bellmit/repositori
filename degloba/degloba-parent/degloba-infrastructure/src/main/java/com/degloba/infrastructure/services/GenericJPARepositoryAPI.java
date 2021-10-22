package com.degloba.infrastructure.services;

import java.io.Serializable;
import java.util.List;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;


public interface GenericJPARepositoryAPI<T, ID extends Serializable> {

	List<T> findAll();

	List<T> findAll(Sort sort);

	List<T> findAllById(Iterable<ID> ids);

	<S extends T> List<S> saveAll(Iterable<S> entities);

	void flush();

	<S extends T> S saveAndFlush(S entity);

	<S extends T> List<S> saveAllAndFlush(Iterable<S> entities);

	@Deprecated
	default void deleteInBatch(Iterable<T> entities){deleteAllInBatch(entities);}

	void deleteAllInBatch(Iterable<T> entities);


	void deleteAllByIdInBatch(Iterable<ID> ids);

	void deleteAllInBatch();

	@Deprecated
	T getOne(ID id);

	T getById(ID id);


	<S extends T> List<S> findAll(Example<S> example);

	<S extends T> List<S> findAll(Example<S> example, Sort sort);

		
}
