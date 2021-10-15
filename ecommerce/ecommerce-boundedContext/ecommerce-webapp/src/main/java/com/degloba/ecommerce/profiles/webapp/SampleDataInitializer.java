package com.degloba.ecommerce.profiles.webapp;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.degloba.ecommerce.profiles.domain.Profile;
import com.degloba.ecommerce.profiles.domain.persistence.nosql.mongo.IProfileReactiveRepository;

import reactor.core.publisher.Flux;

import java.util.UUID;

/**
 * 
 * @author pere
 * 
 * (2) aquest bean inicialitza dades de mostra que només són útils per a una demo. 
 * No volem que aquestes dades de mostra s’inicialitzin cada vegada. 
 * L'anotació del perfil de Spring etiqueta un objecte per inicialitzar-lo només quan el perfil 
 * que coincideix amb el perfil especificat a l'anotació està activat específicament.
 *
 */
@Log4j2 // <1>
@Component
@org.springframework.context.annotation.Profile("demo") // <2>
class SampleDataInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final IProfileReactiveRepository repository; // <3>

    public SampleDataInitializer(IProfileReactiveRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        repository
            .deleteAll() // <4>
            .thenMany(Flux
                    .just("A", "B", "C", "D") // <5>
                    .map(name -> new Profile(UUID.randomUUID().toString(), name + "@email.com")) // <6>                    
                    .flatMap(repository::save) // <7>
            )
            .thenMany(repository.findAll()) // <8>
            .subscribe(profile -> log.info("saving " + profile.toString())); // <9>
    }
}