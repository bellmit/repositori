package com.degloba.ecommerce.cqrs.enviaments.commands;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Value;


/**
 * @category
 * 
 * @author degloba
 *
 */
@Value
@AllArgsConstructor
public class EntregaEnviamentCommand {

	@TargetAggregateIdentifier
    private final String enviamentId;

}
