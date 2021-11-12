package com.degloba.ecommerce.enviaments.cqrs.queries.handlers;

import java.util.HashMap;
import java.util.Map;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.degloba.ecommerce.enviaments.application.IEnviamentService;
import com.degloba.ecommerce.enviaments.cqrs.queries.ObtenirEnviamentQuery;
import com.degloba.ecommerce.enviaments.cqrs.queries.ObtenirEnviamentsQuery;
import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;
import com.degloba.ecommerce.enviaments.eventsourcing.events.EnviamentCreatEvent;
import com.degloba.ecommerce.enviaments.eventsourcing.events.EnviamentEliminatEvent;
import com.degloba.ecommerce.enviaments.eventsourcing.events.EnviamentEntregatEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EnviamentsEventHandler {
	
	@Autowired
	IEnviamentService enviamentService;
	
	  private final Map<String, Enviament> enviaments = new HashMap<>();
	  
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
	        String enviamentId = event.getEnviamentId();
	        enviaments.put(enviamentId, new Enviament(enviamentId, event.getComandaId(), event.getEstatEnviament()));
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
