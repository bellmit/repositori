package com.degloba.ecommerce.cqrs.enviaments.queries.handlers;


import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.degloba.ecommerce.enviaments.application.IEnviamentService;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;
import com.degloba.ecommerce.enviaments.eventsourcing.events.*;
import com.degloba.ecommerce.cqrs.enviaments.queries.ObtenirEnviamentQuery;
import com.degloba.ecommerce.cqrs.enviaments.queries.ObtenirEnviamentsQuery;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EnviamentsEventHandler {
	
	@Autowired
	IEnviamentService enviamentService;

	  
	    /**
	     * 
	     * @param query
	     * @return
	     */
	    @QueryHandler
	    public Flux<Enviament> handle(ObtenirEnviamentsQuery query) {
	        return enviamentService.getAll();
	    }
	    
	    @QueryHandler
	    public Mono<Enviament> handle(ObtenirEnviamentQuery query) {
	        return enviamentService.get(query.getEnviamentId());
	    }

	    @EventHandler
	    public void on(EnviamentCreatEvent event) {
	        enviamentService.create(event.getEnviamentId(), event.getComandaId());
	    }

	    @EventHandler
	    public Void on(EnviamentEliminatEvent event) {
	    	  throw new RuntimeException("not implemented yet!");
	    }
	    
	    @EventHandler
	    public Mono<Void> on(EnviamentEntregatEvent event) {
	    	  throw new RuntimeException("not implemented yet!");
	    }
	    
	    
	    // TODO
}
