package com.degloba.ecommerce.enviaments.cqrs.commands.handlers;

import org.springframework.beans.factory.annotation.Autowired;

import com.degloba.cqrs.commands.annotations.CommandHandlerAnnotation;
import com.degloba.cqrs.commands.handlers.ICommandHandler;
import com.degloba.ecommerce.enviaments.application.IEnviamentService;
import com.degloba.ecommerce.enviaments.cqrs.commands.EntregaEnviamentCommand;


/**
 * @category s'ha rebut un @Command indicant que s'ha de fer un @Enviament
 * 
 * @author degloba
 *
 */
@CommandHandlerAnnotation
public class EnviaComandaCommandHandler implements ICommandHandler<EntregaEnviamentCommand, Void> {

	@Autowired
	IEnviamentService enviamentService;

    @Override
    public Void handle(EntregaEnviamentCommand command) {
    	return enviamentService.envia(command.getEnviamentId());
    }
}
