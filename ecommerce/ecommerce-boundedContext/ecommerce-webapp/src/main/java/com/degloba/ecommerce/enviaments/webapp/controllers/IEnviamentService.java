package com.degloba.ecommerce.enviaments.webapp.controllers;

import org.reactivestreams.Publisher;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.profiles.domain.Profile;
import com.degloba.infrastructure.services.GenericServiceAPI;

/**
 * 
 * @author pere
 *
 */
public interface IEnviamentService extends GenericServiceAPI<Enviament, String> {

	ReactiveMongoRepository<Enviament, String> getDao();

	Publisher<Enviament> update(String id, String comandaId, String estatEnviament);

	Publisher<Enviament>  create(String comandaId, String estatEnviament);

}
