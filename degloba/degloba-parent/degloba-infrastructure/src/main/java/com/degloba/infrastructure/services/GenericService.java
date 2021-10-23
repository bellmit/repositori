package com.degloba.infrastructure.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.degloba.domain.GenericEntity;
import com.degloba.domain.persistence.rdbms.GenericRepository;
import com.degloba.infrastructure.exceptions.NotFoundException;


/**
 * 
 * @author pere
 *
 * https://ultimate.systems/web/blog/generic-controllers-and-services-in-spring-boot-java
 * 
 * @param <T>
 */
public abstract class GenericService<T extends GenericEntity<T>> {

	private final GenericRepository<T> repository;

    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public Page<T> getPage(Pageable pageable){
        return repository.findAll(pageable);
    }

	
	  public T get(Long id){ 
		  return repository.findById(id).orElseThrow( () -> new NotFoundException(id) ); }
	 

    @Transactional
    public T update(T updated){
        T dbDomain = get(updated.getId());
        dbDomain.update(updated);

        return repository.save(dbDomain);
    }

    @Transactional
    public T create(T newDomain){
    	T dbDomain = newDomain.createNewInstance();
        return repository.save(dbDomain);
    }

    @Transactional
    public void delete(Long id){
        //check if object with this id exists
        get(id);
        repository.deleteById(id);
    }
}
