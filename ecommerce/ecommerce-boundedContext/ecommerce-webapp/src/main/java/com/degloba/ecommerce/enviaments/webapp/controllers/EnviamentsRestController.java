package com.degloba.ecommerce.enviaments.webapp.controllers;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
////import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.degloba.ecommerce.enviaments.application.IEnviamentService;
import com.degloba.ecommerce.enviaments.cqrs.commands.GuardarEnviamentCommand;
import com.degloba.ecommerce.enviaments.cqrs.finders.IEnviamentFinder;
import com.degloba.ecommerce.enviaments.cqrs.queries.GetEnviamentQuery;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.EnviamentTemplateOperations;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.IEnviamentReactiveRepository;
import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.degloba.ecommerce.facade.impl.assembler.EnviamentConverter;

@RestController
@CrossOrigin(origins = "http://localhost:8887") // port intern (No Docker)
//@CrossOrigin(origins = "http://webAngularHost:8887")    // port extern (Docker)
@RequestMapping("/enviaments")
public class EnviamentsRestController {

	@Autowired
	IEnviamentService enviamentService;

	@Autowired
	IEnviamentFinder enviamentFinder;
	
	/**
	 * Axon
	 */
	private CommandGateway commandGateway;
	private QueryGateway queryGateway;
	
	@GetMapping()
	// @ResponseStatus(HttpStatus.OK)
	public Mono<EnviamentDto> getEnviament(@RequestParam(required = false) String queryParam) {

		return Mono.fromFuture(queryGateway.query(new GetEnviamentQuery("xxxxx"), EnviamentDto.class));
	}
	

	@GetMapping()
	// @ResponseStatus(HttpStatus.OK)
	public Flux<EnviamentDto> getEnviaments(@RequestParam(required = false) String queryParam) {
////			log.debug("Received request at getExample:" + queryParam);
		return enviamentFinder.buscaEnviaments();
	}

	@PostMapping("add")
	@ResponseStatus(HttpStatus.CREATED)
	public CompletableFuture<Object> postEnviament(@RequestBody EnviamentDto e) {
		return commandGateway.send(new GuardarEnviamentCommand(e));	
	}

}
