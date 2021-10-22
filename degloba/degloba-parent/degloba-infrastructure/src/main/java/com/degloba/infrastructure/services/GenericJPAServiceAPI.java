package com.degloba.infrastructure.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GenericJPAServiceAPI<T, ID extends Serializable> {
	
	T Save(T Entity);
	void delete(ID id);
	Optional<T> get(ID id);
	List<T> getAll();
	
	JpaRepository<T, ID> getDao();
		
}
