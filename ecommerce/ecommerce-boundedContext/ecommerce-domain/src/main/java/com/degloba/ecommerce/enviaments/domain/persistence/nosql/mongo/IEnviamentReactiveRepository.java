package com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


/**
 * 
 * @author pere
 * 
 * Repositori de Mongo Reactiu d'Enviament
 *
 */
public interface IEnviamentReactiveRepository extends ReactiveMongoRepository<Enviament, String> {

}
