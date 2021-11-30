package com.degloba.ecommerce.enviaments.infrastructure.persistence.nosql.mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery.ReactiveFluentQuery;
import org.springframework.stereotype.Repository;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.IEnviamentReactiveRepository;
import com.degloba.infrastructure.services.GenericRepositoryImpl;
import com.mongodb.client.result.DeleteResult;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Slf4j
@Repository
public class EnviamentReactiveRepository extends SimpleReactiveMongoRepository<Enviament, String>
		implements IEnviamentReactiveRepository {

	public EnviamentReactiveRepository(@NonNull MongoEntityInformation<Enviament, String> entityInformation,
			@NonNull ReactiveMongoOperations mongoOperations) {
		super(entityInformation, mongoOperations);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Flux<Enviament> findAllByIdNotNullOrderByIdAsc(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
