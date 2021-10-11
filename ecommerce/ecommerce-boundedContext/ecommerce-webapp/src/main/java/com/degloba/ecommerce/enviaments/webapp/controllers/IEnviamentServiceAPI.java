package com.degloba.ecommerce.enviaments.webapp.controllers.impl.spring;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.domain.services.GenericServiceAPI;

/**
 * 
 * @author pere
 *
 */
public interface IEnviamentServiceAPI extends GenericServiceAPI<Enviament, String> {

	ReactiveMongoRepository<Enviament, String> getDao();
}
