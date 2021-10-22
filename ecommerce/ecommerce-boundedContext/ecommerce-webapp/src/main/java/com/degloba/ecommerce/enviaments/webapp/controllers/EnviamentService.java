package com.degloba.ecommerce.enviaments.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.IEnviamentReactiveRepository;

import com.degloba.ecommerce.enviaments.eventsourcing.events.EnviamentCreatedEvent;
import com.degloba.infrastructure.services.GenericServiceImpl;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author pere
 *
 */
@Service
public class EnviamentService extends GenericServiceImpl<Enviament, String> implements IEnviamentService {

	private ApplicationEventPublisher publisher; 
    
	   
	@Autowired
	private IEnviamentReactiveRepository enviamentReactiveRepository;
	
	@Override
	public ReactiveMongoRepository<Enviament, String> getDao() {
		return enviamentReactiveRepository;
	}
	
	public Flux<Enviament> all() {
		  return this.enviamentReactiveRepository
			  .findAll();			
	}
	
   /**
    * 
    * @param id
    * @param comandaId
    * @param estatEnviament
    * @return
    */
	public Mono<Enviament> update(String id, String comandaId, String estatEnviament) { 
	        return this.enviamentReactiveRepository
	            .findById(id)
	            .map(e -> new Enviament(e.getEnviamentId(), comandaId, estatEnviament))
	            .flatMap(this.enviamentReactiveRepository::save);
	    }

    public Mono<Void> delete(String id) { 
        return this.enviamentReactiveRepository
            .findById(id)
            .flatMap(e -> this.enviamentReactiveRepository.deleteById(e.getEnviamentId()).then());    ///Return(e));
    }

    /**
     * Crea un Enviament nou a la base de dades i publiquem l'event EnviamentCreatedEvent 
     * si el Save ha acabat bé. 
     * El Callback doOnSuccess pren un Consumer<T> que s'invoca després que les dades del pipeline reactiu 
     * s'hagin escrit a la base de dades.  
     * @param comandaId
     * @param estatEnviament
     * @return
     */
    public Mono<Enviament> create(String comandaId, String estatEnviament) { 
        return this.enviamentReactiveRepository
            .save(new Enviament(null, comandaId, estatEnviament ))
            .doOnSuccess(e -> this.publisher.publishEvent(new EnviamentCreatedEvent(e)));
    }

}
