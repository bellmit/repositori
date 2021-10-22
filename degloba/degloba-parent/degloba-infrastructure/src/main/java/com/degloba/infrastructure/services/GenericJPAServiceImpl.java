package com.degloba.infrastructure.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public abstract class GenericJPAServiceImpl<T, ID extends Serializable> implements GenericJPAServiceAPI<T, ID> {

	
	@Override
	public T Save(T Entity) {
		return getDao().save(Entity);
	}

	
	  @Override 
	  public void delete(ID id) { 
		   getDao().deleteById(id); 
		  }
	  
	  @Override public Optional<T> get(ID id) { 
		  return getDao().findById(id); 
		  }
	 

	@Override
	public List<T> getAll() {
		return getDao().findAll();
	}


}
