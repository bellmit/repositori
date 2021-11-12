package com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Spring5ReactiveApplication.class)
public class EnviamentTemplateOperationsManualTest {

    @Autowired
    EnviamentTemplateOperations enviamentTemplate;

    @Test
    public void givenEnviament_whenSave_thenSave() {
    	Enviament enviament = enviamentTemplate.save(Mono.just(new Enviament("", "comanda1", "estat1"))).block();
        assertNotNull( enviament.getEnviamentId() );
    }

    @Test
    public void givenId_whenFindById_thenFindEnviament() {
        Mono<Enviament> enviamentMono = enviamentTemplate.save(Mono.just(new Enviament("", "comanda1", "estat1")));
        Mono<Enviament> enviamentMonoResult = enviamentTemplate.findById(enviamentMono.block().getEnviamentId());
        assertNotNull(enviamentMonoResult.block().getEnviamentId());
        assertEquals(enviamentMonoResult.block().getComandaId(), "comanda1");
    }

    @Test
    public void whenFindAll_thenFindAllAEnviaments() {
    	Enviament enviament1 = enviamentTemplate.save(Mono.just(new Enviament("", "comanda1", "estat1"))).block();
    	Enviament enviament2 = enviamentTemplate.save(Mono.just(new Enviament("", "comanda2", "estat2"))).block();
        Flux<Enviament> enviamentFlux = enviamentTemplate.findAll();
        List<Enviament> enviaments = enviamentFlux.collectList().block();
        assertTrue(enviaments.stream().anyMatch(x -> enviament1.getEnviamentId().equals(x.getEnviamentId()) ));
        assertTrue(enviaments.stream().anyMatch(x -> enviament2.getEnviamentId().equals(x.getEnviamentId()) ));
    }

}

