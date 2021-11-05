package com.degloba.ecommerce.enviaments.webreactive.reactive.functional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @category client del {@link EnviamentsRestController} que utilitza
 *           {@link WebClient} per poder fer requests HTTP no-bloquejants
 *           (s'executen en paralel!!!!)
 * 
 * @category encapsula l'execució de peticions http/Rest en paralel
 * 
 * @author degloba
 *
 */
@Service
public class EnviamentWebClientService {

	String url = "http://localhost:8080";
	// String url = "http://ecommerce-webapp:8880/enviaments/";

	public Flux<EnviamentDto> buscarTotsEnviaments() {

		WebClient webclient = WebClient.create(url + "/enviaments");

		// simulem una lògica de negoci en la part web (front-End)
		// accedint a diferents RestControllers (en aquest cas d'exemple es el mateix
		// Rest)
		Flux<EnviamentDto> fluxEnviament1 = webclient.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(EnviamentDto.class);
		Flux<EnviamentDto> fluxEnviament2 = webclient.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(EnviamentDto.class);
		Flux<EnviamentDto> fluxEnviament3 = webclient.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(EnviamentDto.class);
		Flux<EnviamentDto> fluxEnviament4 = webclient.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(EnviamentDto.class);
		Flux<EnviamentDto> fluxEnviament5 = webclient.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(EnviamentDto.class);
		Flux<EnviamentDto> fluxEnviament6 = webclient.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(EnviamentDto.class);

		Flux<EnviamentDto> fluxEnviaments = Flux.merge(fluxEnviament1, fluxEnviament2, fluxEnviament3, fluxEnviament4,
				fluxEnviament5, fluxEnviament6);

		return fluxEnviaments; // si els diferents webservices ens tornen DTOs

	}

	public Mono<EnviamentDto> buscarEnviamentById(String id) {
		WebClient webclient = WebClient.create(url + id);

		return webclient.get().retrieve().bodyToMono(EnviamentDto.class);
	}

	public Mono<EnviamentDto> updateEnviament(EnviamentDto enviament) {

		WebClient webclient = WebClient.create(url);

		Enviament enviament2 = new Enviament(enviament.getEnviamentId(), enviament.getComandaId(),
				enviament.getEstatEnviament());

		Mono<EnviamentDto> enviamentMono = webclient.post().uri("/enviaments/add")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(enviament2), Enviament.class).retrieve().bodyToMono(EnviamentDto.class);

		enviamentMono.subscribe();

		return enviamentMono;
	}
	
	 public void consume() {
		 
		 	WebClient webclient = WebClient.create(url);

			/*
			 * Mono<EnviamentDto> enviamentMono = client.get() .uri("/enviaments/{id}", "1")
			 * .accept(MediaType.APPLICATION_JSON) .retrieve()
			 * .bodyToMono(EnviamentDto.class);
			 * 
			 * enviamentMono.subscribe(System.out::println);
			 */
	        
	        Flux<EnviamentDto> enviamentFlux = webclient.get()
	            .uri("/enviaments/")
	            .accept(MediaType.APPLICATION_JSON)
	            .retrieve()	           
	            .bodyToFlux(EnviamentDto.class);
	        
	        enviamentFlux.subscribe(System.out::println);
	    }
}