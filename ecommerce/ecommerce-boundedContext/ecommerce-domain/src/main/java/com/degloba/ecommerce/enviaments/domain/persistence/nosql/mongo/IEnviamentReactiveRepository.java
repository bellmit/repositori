package com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface IEnviamentReactiveRepository extends ReactiveMongoRepository<Enviament, String> {

}
