package com.degloba.ecommerce.enviaments.infrastructure.persistence.nosql.mongo;

import java.util.HashMap;
import java.util.Map;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.IEnviamentReactiveRepository;
import com.degloba.infrastructure.services.GenericRepositoryImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class EnviamentReactiveRepository extends GenericRepositoryImpl<Enviament, String> implements IEnviamentReactiveRepository {
	


}
