package com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


/**
 * 
 * @author pere
 * 
 * Repositori de Mongo Reactiu d'Enviament
 *
 */
@ComponentScan({"com.degloba.ecommerce"})
@EntityScan("com.degloba.ecommerce")
public interface IEnviamentReactiveRepository extends ReactiveMongoRepository<Enviament, String> {

}
