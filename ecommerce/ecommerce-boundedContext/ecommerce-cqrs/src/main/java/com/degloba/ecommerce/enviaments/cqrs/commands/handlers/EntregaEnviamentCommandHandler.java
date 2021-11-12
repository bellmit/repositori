package com.degloba.ecommerce.enviaments.cqrs.commands.handlers;


import org.springframework.beans.factory.annotation.Autowired;

import com.degloba.cqrs.commands.annotations.CommandHandlerAnnotation;
import com.degloba.cqrs.commands.handlers.ICommandHandler;
import com.degloba.ecommerce.enviaments.application.IEnviamentService;
import com.degloba.ecommerce.enviaments.cqrs.commands.EntregaEnviamentCommand;


/**
 * @category 
 * 
 * @author degloba
 *
 */
@CommandHandlerAnnotation
public class EntregaEnviamentCommandHandler implements ICommandHandler<EntregaEnviamentCommand, Void> {

	@Autowired
	IEnviamentService enviamentService;

    @Override
    public Void handle(EntregaEnviamentCommand command) {
    	return enviamentService.entregarEnviament(command.getEnviamentId());
    }
}
