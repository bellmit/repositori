package com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;

import reactor.core.publisher.Flux;

import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.data.mongodb.repository.support.SimpleReactiveMongoRepository;


/**
 * 
 * @author pere
 * 
 * Repositori de Mongo Reactiu d'Enviament
 *
 */
@Repository
public interface IEnviamentReactiveRepository extends ReactiveMongoRepository<Enviament, String> {

	
	Flux<Enviament> findAllByIdNotNullOrderByIdAsc(final Pageable page);
	
}
