package com.degloba.ecommerce.enviaments.eventsourcing.events;

import org.springframework.context.ApplicationEvent;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;

import lombok.Data;


@Data
public class EnviamentCreatedEvent extends ApplicationEvent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String enviamentId;

	public EnviamentCreatedEvent(Enviament source) {
        super(source);
    }
}
