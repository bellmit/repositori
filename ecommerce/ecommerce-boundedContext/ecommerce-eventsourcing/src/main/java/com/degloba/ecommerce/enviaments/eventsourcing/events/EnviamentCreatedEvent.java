package com.degloba.ecommerce.enviaments.eventsourcing.events;

import org.springframework.context.ApplicationEvent;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;


public class EnviamentCreatedEvent extends ApplicationEvent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnviamentCreatedEvent(Enviament source) {
        super(source);
    }
}
