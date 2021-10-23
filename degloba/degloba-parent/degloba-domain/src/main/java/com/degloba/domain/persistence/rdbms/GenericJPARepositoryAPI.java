package com.degloba.domain.persistence.rdbms;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public interface GenericJPARepositoryAPI<T, ID extends Serializable> {

	List<T> findAll();

	List<T> findAll(Sort sort);

	List<T> findAllById(Iterable<String> ids);

	<S extends T> List<S> saveAll(Iterable<S> entities);

	void flush();

	<S extends T> S saveAndFlush(S entity);

	void deleteAllInBatch(Iterable<T> entities);

	<S extends T> List<S> saveAllAndFlush(Iterable<S> entities);


	void deleteAllInBatch();

	void deleteAllByIdInBatch(Iterable<String> ids);

	T getOne(String id);

	T getById(String id);

	<S extends T> List<S> findAll(Example<S> example);

	Page<T> findAll(Pageable pageable);

	<S extends T> S save(S entity);

	Optional<T> findById(String id);

	<S extends T> List<S> findAll(Example<S> example, Sort sort);

	boolean existsById(String id);

	long count();

	void deleteById(String id);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(T entity);

	void deleteAll(Iterable<? extends T> entities);

	void deleteAll();

	<S extends T> Optional<S> findOne(Example<S> example);

	<S extends T> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends T> long count(Example<S> example);

	<S extends T> boolean exists(Example<S> example);

		
}
