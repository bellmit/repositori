package com.degloba.ecommerce.enviaments.cqrs.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreaEnviamentCommand {

	@TargetAggregateIdentifier
    private final String enviamentId;
	
	private String comandaId;
	
	private String estat;
}
