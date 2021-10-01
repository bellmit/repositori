package com.degloba.ecommerce.enviaments.webapp.controllers.impl.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.IEnviamentReactiveRepository;
import com.degloba.ecommerce.enviaments.domain.services.GenericServiceImpl;
import com.degloba.ecommerce.enviaments.webapp.controllers.impl.spring.EnviamentReactiveRepository;

/**
 * 
 * @author pere
 *
 */
@Service
public class EnviamentServiceImpl extends GenericServiceImpl<Enviament, String> implements IEnviamentServiceAPI {

	@Autowired
	private IEnviamentReactiveRepository enviamentReactiveRepository;
	
	@Override
	public ReactiveMongoRepository<Enviament, String> getDao() {
		return enviamentReactiveRepository;
	}


}
