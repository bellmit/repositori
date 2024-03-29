package com.degloba.ecommerce.crm.cqrs.commands;



import lombok.Value;

/**
 * @category Command que indica que s'ha d'enviar la comanda<br>
 * Implementat amb Axon
 * 
 * @author degloba
 *
 */
@Value
public class EnviaComandaCommand {
	
	////@TargetAggregateIdentifier
    private final String comandaId;

}
