package com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;


/**
 * 
 * @author pere
 * 
 * Repositori de Mongo Reactiu d'Enviament
 *
 */
public interface IEnviamentReactiveRepository extends ReactiveMongoRepository<Enviament, String> {

}
