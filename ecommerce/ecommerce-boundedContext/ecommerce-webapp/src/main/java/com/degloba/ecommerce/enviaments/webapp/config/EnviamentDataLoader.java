package com.degloba.ecommerce.enviaments.webapp.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.IEnviamentReactiveRepository;

import reactor.core.publisher.Flux;



@Component
public class EnviamentDataLoader implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(EnviamentDataLoader.class);

    private final IEnviamentReactiveRepository enviamentMongoReactiveRepository;

    EnviamentDataLoader(final IEnviamentReactiveRepository enviamentMongoReactiveRepository) {
        this.enviamentMongoReactiveRepository = enviamentMongoReactiveRepository;
    }

    @Override
    public void run(final ApplicationArguments args) {
        if (enviamentMongoReactiveRepository.count().block() == 0L) {
            var idSupplier = getIdSequenceSupplier();
            var bufferedReader = new BufferedReader(
                    new InputStreamReader(getClass()
                            .getClassLoader()
                            .getResourceAsStream("pg2000.txt"))
            );
            Flux.fromStream(
                    bufferedReader.lines()
                            .filter(l -> !l.trim().isEmpty())
                            .map(l -> enviamentMongoReactiveRepository.save(
                                    new Enviament(idSupplier.get(),
                                            "comada1", l))
                            )
            ).subscribe(m -> log.info("New enviament loaded: {}", m.block()));
            log.info("Repository contains now {} entries.",
            		enviamentMongoReactiveRepository.count().block());
        }
    }

    private Supplier<String> getIdSequenceSupplier() {
        return new Supplier<>() {
            Long l = 0L;

            @Override
            public String get() {
                // adds padding zeroes
                return String.format("%05d", l++);
            }
        };
    }
}
