package com.degloba.ecommerce.enviaments.webapp.commandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.IEnviamentReactiveRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;


@Component
@Slf4j
class DataInitializer implements CommandLineRunner {
    private final IEnviamentReactiveRepository repositori;
    
    public DataInitializer(IEnviamentReactiveRepository repositori) {
        this.repositori = repositori;
    }
    
    @Override
    public void run(String[] args) {
        log.info("start data initialization  ...");
        this.repositori
                .deleteAll()
                .thenMany(
                        Flux
                                .just("Enviament primer", "Enviament segon")
                                .flatMap(
                                        enviament -> this.repositori.save(Enviament.builder().enviamentId(enviament).comandaId("2").build())
                                )
                )
                .log()
                .subscribe(
                        null,
                        null,
                        () -> log.info("done initialization...")
                );
    }
}
