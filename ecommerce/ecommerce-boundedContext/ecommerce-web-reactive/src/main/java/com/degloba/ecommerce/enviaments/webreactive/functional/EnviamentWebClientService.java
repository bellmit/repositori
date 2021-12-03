package com.degloba.ecommerce.enviaments.webreactive.functional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;
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
	// Exemple : suposem que per obtenir un {@link EnviamentDto} és necessari fer crides a
	//           diferents serveis web
	// Opcio1 : executar sequencialment serveiWeb1, serveiWeb2,... i després "construir" els {@link EnviamentDto}
	// Opcio2 : executar en paralel serveiWeb1, serveiWeb2,... i un cop tenim tota la informació "construir" els {@link EnviamentDto} 
	
	
	// exemple : 4 serveis web (urlS)
	String url1 = "http://localhost:8080";
	String url2 = "http://localhost:8080";
	String url3 = "http://localhost:8080";
	String url4 = "http://localhost:8080";
	
	// exemple : 4 serveis web (urlS)
	WebClient webclient1 = WebClient.create(url1 + "/enviaments");
	WebClient webclient2 = WebClient.create(url2 + "/enviaments");
	WebClient webclient3 = WebClient.create(url3 + "/enviaments");
	WebClient webclient4 = WebClient.create(url4 + "/enviaments");
	
	// String url = "http://ecommerce-webapp:8880/enviaments/";

	@Cacheable(value = "buscarTotsEnviamentsCache")
	public Flux<EnviamentDto> buscarTotsEnviaments() {

		// simulem una lògica de negoci en la part web (front-End)
		// accedint a diferents RestControllers (en aquest cas d'exemple es el mateix
		// Rest)
		
		//simula l'execució de diferents URLs en paralel
		Flux<EnviamentDto> fluxEnviament1 = webclient1.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(EnviamentDto.class);
		Flux<EnviamentDto> fluxEnviament2 = webclient2.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(EnviamentDto.class);
		Flux<EnviamentDto> fluxEnviament3 = webclient3.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(EnviamentDto.class);
		Flux<EnviamentDto> fluxEnviament4 = webclient4.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(EnviamentDto.class);

		// Merge diferent {@link Flux}
		Flux<EnviamentDto> fluxEnviaments = Flux.merge(fluxEnviament1, fluxEnviament2, fluxEnviament3, fluxEnviament4);

		return fluxEnviaments; // si els diferents webservices ens tornen DTOs
	}

	public Mono<EnviamentDto> buscarEnviamentById(String id) {
		WebClient webclient = WebClient.create(url1 + id);

		return webclient.get().retrieve().bodyToMono(EnviamentDto.class);
	}

	public Mono<EnviamentDto> updateEnviament(EnviamentDto enviamentDto) {

		WebClient webclient = WebClient.create(url1);

		Enviament enviament = new Enviament(enviamentDto.getEnviamentId(), enviamentDto.getComandaId(), enviamentDto.getEstat());

		Mono<EnviamentDto> enviamentMono = webclient.post().uri("/enviaments/add")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(enviament), Enviament.class).retrieve().bodyToMono(EnviamentDto.class);

		enviamentMono.subscribe();

		return enviamentMono;
	}
	
}