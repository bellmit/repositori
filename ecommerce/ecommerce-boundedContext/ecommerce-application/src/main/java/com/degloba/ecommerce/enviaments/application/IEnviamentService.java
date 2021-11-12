package com.degloba.ecommerce.enviaments.application;

import org.reactivestreams.Publisher;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.degloba.application.GenericServiceAPI;
import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;



/**
 *  * @author pere
 *
 */
public interface IEnviamentService extends GenericServiceAPI<Enviament, String> {

	ReactiveMongoRepository<Enviament, String> getDao();

	Publisher<Enviament> update(String id, String comandaId, String estatEnviament);

	Publisher<Enviament> create(String comandaId, String estatEnviament);


}
