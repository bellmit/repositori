package com.degloba.ecommerce.webapp.enviaments.controllers;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.callbacks.LoggingCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.extensions.reactor.commandhandling.gateway.ReactorCommandGateway;
import org.axonframework.extensions.reactor.queryhandling.gateway.ReactorQueryGateway;
//import org.axonframework.extensions.reactor.commandhandling.gateway.ReactorCommandGateway;
//import org.axonframework.extensions.reactor.queryhandling.gateway.ReactorQueryGateway;
import org.axonframework.messaging.ExecutionException;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.GenericQueryMessage;
import org.axonframework.queryhandling.QueryGateway;
import org.hamcrest.CoreMatchers;
////import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.degloba.ecommerce.cqrs.enviaments.commands.CreaEnviamentCommand;
import com.degloba.ecommerce.cqrs.enviaments.queries.ObtenirEnviamentQuery;
import com.degloba.ecommerce.cqrs.enviaments.queries.ObtenirEnviamentsQuery;
import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;
//import com.querydsl.core.Query;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


/**
 * RestController 
 * 
 * @author pere
 *
 */
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:8887") // port intern (No Docker)
//@CrossOrigin(origins = "http://webAngularHost:8887")    // port extern (Docker)
@RequestMapping("/enviaments")
public class EnviamentsRestController {

	/**
	 * Axon
	 */
	private CommandGateway commandGateway;
	private QueryGateway queryGateway;
	
	// https://docs.axoniq.io/reference-guide/extensions/reactor/reactive-gateways
	private ReactorQueryGateway reactiveQueryGateway;
	private ReactorCommandGateway reactiveCommandGateway; 
	
	/**
	 * GET is used to request data from a specified resource.
	 * 
	 * @param queryParam
	 * @return
	 */
	@GetMapping("/{id}")
	// @ResponseStatus(HttpStatus.OK)
	public Mono<EnviamentDto> getEnviament(@PathVariable String id) throws InterruptedException, ExecutionException {
		//return reactiveQueryGateway.query(new ObtenirEnviamentQuery(id), EnviamentDto.class);
		return Mono.fromFuture(queryGateway.query(new ObtenirEnviamentQuery(id), EnviamentDto.class));
	}
	

	@GetMapping()
	// @ResponseStatus(HttpStatus.OK)
	public Flux<EnviamentDto> getEnviaments(@RequestParam(required = false) String queryParam) {
		GenericQueryMessage<String, List<EnviamentDto>> query2 =
		        new GenericQueryMessage<>("criteria", "query", ResponseTypes.multipleInstancesOf(EnviamentDto.class));
		// send a query message and print query response
		
		//Query query = null;
		//return reactiveQueryGateway.scatterGather(query2, ResponseTypes.instanceOf(EnviamentDto.class), Duration.ofSeconds(5)).take(3);
		
	
////			log.debug("Received request at getExample:" + queryParam);
		
//		return Flux.fromStream(queryGateway.query(new ObtenirEnviamentsQuery(), 
//				ResponseTypes.instanceOf(EnviamentDto.class)));
				
		// (1)
		return reactiveQueryGateway.scatterGather(new ObtenirEnviamentsQuery(), 
				ResponseTypes.instanceOf(EnviamentDto.class), Duration.ofSeconds(5)).take(1);
		
		
		// (2)
		//return reactiveQueryGateway.subscriptionQuery("criteriaQuery", EnviamentDto.class);
		
		// (22)  . (22) es equivalent a (2)
//		return reactiveQueryGateway.subscriptionQuery(new ObtenirEnviamentsQuery(), 
//				ResponseTypes.instanceOf(EnviamentDto.class), 
//				ResponseTypes.instanceOf(EnviamentDto.class))
//                .flatMapMany(result -> result.initialResult()
//                                             .concatWith(result.updates())
//                                             .doFinally(signal -> result.close()));
		
		// (3)
		//return reactiveQueryGateway.subscriptionQueryMany(new ObtenirEnviamentsQuery(), EnviamentDto.class);
		
		// (33)   . (33) es equivalent a (3)
//		return reactiveQueryGateway.subscriptionQuery(new ObtenirEnviamentsQuery(),
//                ResponseTypes.multipleInstancesOf(EnviamentDto.class),
//                ResponseTypes.instanceOf(EnviamentDto.class))
//					.flatMapMany(result -> result.initialResult()
//                          .flatMapMany(Flux::fromIterable)
//                          .concatWith(result.updates())
//                          .doFinally(signal -> result.close()));
		
		// (4)
		//return reactiveQueryGateway.queryUpdates("criteriaQuery", EnviamentDto.class);
		
		// (44)     . (44) es equivalent a (4)
//		return reactiveQueryGateway.subscriptionQuery(new ObtenirEnviamentsQuery(), Void.class, EnviamentDto.class)
//                .flatMapMany(result -> result.updates()
//                                             .doFinally(signal -> result.close()));
		
		
	}
	
   
	/**
	 * POST is used to send data to a server to create/update a resource.
	 */
	@PostMapping("add")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(
	        value = "add", method = RequestMethod.POST,
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
    public Mono<Void> addEnviament(@RequestBody EnviamentDto enviamentDto) {
        //return reactiveCommandGateway.send(new CreaEnviamentCommand(enviamentDto.enviamentId,enviamentDto.getComandaId(),enviamentDto.getEstat()));
        return Mono.fromFuture(commandGateway.send(new CreaEnviamentCommand(enviamentDto.enviamentId,enviamentDto.getComandaId(),enviamentDto.getEstat())));       
    }
	

	/**
	 * PUT is used to send data to a server to create/update a resource.
	 * 
	 * La diferencia entre POST y PUT es que las solicitudes PUT son idempotentes. Es decir, llamar a la misma solicitud PUT 
	 * varias veces siempre producirá el mismo resultado. Por el contrario, 
	 * llamar a una solicitud POST repetidamente tiene los efectos secundarios de crear el mismo recurso varias veces.
	 */



}
