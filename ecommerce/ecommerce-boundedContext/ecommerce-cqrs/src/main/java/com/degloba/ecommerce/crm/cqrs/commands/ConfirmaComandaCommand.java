package com.degloba.ecommerce.crm.cqrs.commands;



import lombok.Value;

/**
 * @category Command que indica<br>
 * Implementat amb Axon
 * 
 * @author degloba
 *
 */
@Value
public class ConfirmaComandaCommand {
	
	/////@TargetAggregateIdentifier
    private final String comandaId;

	
}
