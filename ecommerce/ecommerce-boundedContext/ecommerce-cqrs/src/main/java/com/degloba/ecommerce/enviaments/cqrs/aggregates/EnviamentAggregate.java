package com.degloba.ecommerce.enviaments.cqrs.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import com.degloba.ecommerce.enviaments.application.IEnviamentService;
import com.degloba.ecommerce.enviaments.cqrs.commands.CreaEnviamentCommand;
import com.degloba.ecommerce.enviaments.cqrs.commands.EliminaEnviamentCommand;
import com.degloba.ecommerce.enviaments.cqrs.commands.EntregaEnviamentCommand;
import com.degloba.ecommerce.enviaments.cqrs.commands.GuardaEnviamentCommand;
import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;
import com.degloba.ecommerce.enviaments.eventsourcing.events.EnviamentCreatEvent;
import com.degloba.ecommerce.enviaments.eventsourcing.events.EnviamentEliminatEvent;
import com.degloba.ecommerce.enviaments.eventsourcing.events.EnviamentEntregatEvent;
import com.degloba.ecommerce.enviaments.eventsourcing.events.EnviamentGuardatEvent;
import com.degloba.ecommerce.facade.impl.assembler.EnviamentConverter;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class EnviamentAggregate {
	
	@Autowired
	IEnviamentService enviamentService;

	@AggregateIdentifier
    private String enviamentId;
    private boolean enviamentConfirmat;
    
    protected EnviamentAggregate() {
        // Required by Axon to build a default Aggregate prior to Event Sourcing
    }

    @CommandHandler
    public EnviamentAggregate(CreaEnviamentCommand creaEnviamentCommand) {
    	
		Enviament e = new Enviament(creaEnviamentCommand.getEnviamentId(),creaEnviamentCommand.getComandaId(),creaEnviamentCommand.getEstat());
		
		enviamentService.Save(e).flatMap(ee -> EnviamentConverter.toDto(ee));
    	    	
        apply(new EnviamentCreatEvent(creaEnviamentCommand.getEnviamentId(), creaEnviamentCommand.getComandaId(), creaEnviamentCommand.getEstat()));
    }
    
    
    @CommandHandler
    public void handle(EntregaEnviamentCommand command) {
        apply(new EnviamentEntregatEvent(command.getEnviamentId()));
    }
    
    @CommandHandler
    public void handle(GuardaEnviamentCommand command) {
        apply(new EnviamentGuardatEvent(command.getEnviamentId(), command.getComandaId(), command.getEstat()));
    }
    
    @CommandHandler
    public void handle(EliminaEnviamentCommand command) {
        apply(new EnviamentEliminatEvent(command.getEnviamentId()));
    }

    @EventSourcingHandler
    public void on(EnviamentCreatEvent event) {
        this.enviamentId = event.getEnviamentId();
        enviamentConfirmat = false;
    }

}