package com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Spring5ReactiveApplication.class)
public class EnviamentReactiveRepositoryTest {

	 @Autowired
	    IEnviamentReactiveRepository repository;

	    @Test
	    public void givenExample_whenFindAllWithExample_thenFindAllMacthings() {
	        repository.save(new Enviament("", "comanda1", "estat1")).block();
	        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("comandaId", startsWith());
	        Example<Enviament> example = Example.of(new Enviament(null, "com", null), matcher);
	        Flux<Enviament> enviamentFlux = repository.findAll(example);

	        StepVerifier
	                .create(enviamentFlux)
	                .assertNext(enviament -> assertEquals("comanda1", enviament.getComandaId()))
	                .expectComplete()
	                .verify();
	    }

	    @Test
	    public void givenEnviament_whenSave_thenSave() {
	        Mono<Enviament> enviamentMono = repository.save(new Enviament("", "comanda1", "estat1"));

	        StepVerifier
	                .create(enviamentMono)
	                .assertNext(enviament -> assertNotNull(enviament.getEnviamentId()))
	                .expectComplete()
	                .verify();
	    }

	    @Test
	    public void givenId_whenFindById_thenFindEnviament() {
	    	Enviament inserted = repository.save(new Enviament("", "comanda1", "estat1")).block();
	        Mono<Enviament> enviamentMono = repository.findById(inserted.getEnviamentId());

	        StepVerifier
	                .create(enviamentMono)
	                .assertNext(enviament -> {
	                    //assertEquals("comanda1", enviament.getComandaId());
	                    //assertEquals("estat1",  enviament.getEstatEnviament());
	                    assertNotNull(enviament.getEnviamentId());
	                })
	                .expectComplete()
	                .verify();
	    }
}
