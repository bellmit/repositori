package com.degloba.ecommerce.cqrs.enviaments.commands.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import com.degloba.ecommerce.cqrs.enviaments.commands.*;
import com.degloba.ecommerce.enviaments.application.EnviamentService;
import com.degloba.ecommerce.enviaments.application.IEnviamentService;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;
import com.degloba.ecommerce.eventsourcing.enviaments.events.*;
import com.degloba.ecommerce.facade.impl.assembler.EnviamentConverter;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate(repository = "accountAggregateEventSourcingRepository")
public class EnviamentAggregate {


	@AggregateIdentifier
    private String enviamentId;
    private boolean enviamentConfirmat;
    
    protected EnviamentAggregate() {
        // Required by Axon to build a default Aggregate prior to Event Sourcing
    }

    /**
     * Constructor amb el paràmetre {@link CreaEnviamentCommand}
     * @param creaEnviamentCommand
     */
    @CommandHandler
    public EnviamentAggregate(CreaEnviamentCommand creaEnviamentCommand) {   //https://stackoverflow.com/questions/54505687/aggregate-not-found-in-the-event-store
    	
		Enviament e = new Enviament(creaEnviamentCommand.getEnviamentId(),creaEnviamentCommand.getComandaId(),creaEnviamentCommand.getEstat());
		    	
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
