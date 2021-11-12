package com.degloba.ecommerce.enviaments.cqrs.handlers;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import com.degloba.ecommerce.enviaments.application.IEnviamentService;
import com.degloba.ecommerce.enviaments.cqrs.commands.GuardarEnviamentCommand;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.eventsourcing.events.EnviamentCreatedEvent;
import com.degloba.ecommerce.facade.impl.assembler.EnviamentConverter;

@Aggregate
public class EnviamentCommandHandlers {
	
	@Autowired
	IEnviamentService enviamentService;
	
	@CommandHandler
	public EnviamentCommandHandlers(GuardarEnviamentCommand cmd) {
		//Assert.notNull(cmd.getLibraryId(), "ID should not be null");
		//Assert.notNull(cmd.getName(), "Name should not be null");

		//AggregateLifecycle.apply(new LibraryCreatedEvent(cmd.getLibraryId(), cmd.getName()));
		
		Enviament e = new Enviament(cmd.getEnviamentId(),cmd.getComanda(),cmd.getEstat());
		
		//enviamentService.Save(e).flatMap(ee -> EnviamentConverter.toDto(ee));
		enviamentService.Save(e).flatMap(ee -> EnviamentConverter.toDto(ee));		
	}
	
	@EventSourcingHandler
	private void handleCreatedEvent(EnviamentCreatedEvent event) {
		//enviamentId = event.getEnviamentId();

	}


}
