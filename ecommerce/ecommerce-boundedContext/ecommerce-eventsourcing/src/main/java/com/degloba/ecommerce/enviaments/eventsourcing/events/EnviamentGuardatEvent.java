package com.degloba.ecommerce.enviaments.eventsourcing.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Value
@Data
@AllArgsConstructor
public class EnviamentGuardatEvent {
	
	public String enviamentId;
	
	public String comandaId;
	
	public String estat;

}
