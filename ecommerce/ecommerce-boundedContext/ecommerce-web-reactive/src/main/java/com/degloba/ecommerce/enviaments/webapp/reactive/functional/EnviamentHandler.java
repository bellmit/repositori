package com.degloba.ecommerce.enviaments.webapp.reactive.functional;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.webapp.services.EnviamentService;


import java.net.URI;

@Component
public class EnviamentHandler {

    // <1>
    private final EnviamentService enviamentService;

    EnviamentHandler(EnviamentService enviamentService) {
        this.enviamentService = enviamentService;
    }
    

    // <2>
    Mono<ServerResponse> getById(ServerRequest r) {
        return defaultReadResponse(this.enviamentService.get(id(r)));
    }

	
	  Flux<ServerResponse> all(ServerRequest r) { return
	  defaultReadResponse_v2(this.enviamentService.all()); }
	 

	
	/*
	 * Mono<ServerResponse> deleteById(ServerRequest r) { return
	 * defaultReadResponse(this.enviamentService.delete(id(r))); }
	 */
	 
    Mono<ServerResponse> updateById(ServerRequest r) {
        Flux<Enviament> id = r.bodyToFlux(Enviament.class)
            .flatMap(e -> this.enviamentService.update(id(r), e.getComandaId(), e.getEstatEnviament()));
        return defaultReadResponse(id);
    }

    Mono<ServerResponse> create(ServerRequest request) {
        Flux<Enviament> flux = request
            .bodyToFlux(Enviament.class)
            .flatMap(toWrite -> this.enviamentService.create(toWrite.getComandaId(),toWrite.getEstatEnviament()));
        return defaultWriteResponse(flux);
    }

    // <3>
    private static Mono<ServerResponse> defaultWriteResponse(Publisher<Enviament> enviaments) {
        return Mono
            .from(enviaments)
            .flatMap(e -> ServerResponse
                .created(URI.create("/enviaments/" + e.getEnviamentId()))
                .contentType(MediaType.APPLICATION_JSON)
                .build()
            );
    }

    // <4>
    private Mono<ServerResponse> defaultReadResponse(Publisher<Enviament> enviaments) {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(enviaments, Enviament.class);
    }
    
    private Flux<ServerResponse> defaultReadResponse_v2(Flux<Enviament> flux) {
		  return ServerResponse .ok() .contentType(MediaType.APPLICATION_JSON)
	  .body(flux, Enviament.class).concatWith(null);
		 
    }

    private static String id(ServerRequest r) {
        return r.pathVariable("id");
    }
}
