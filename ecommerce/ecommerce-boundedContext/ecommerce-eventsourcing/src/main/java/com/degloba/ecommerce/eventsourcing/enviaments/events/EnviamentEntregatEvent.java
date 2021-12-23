package com.degloba.ecommerce.eventsourcing.enviaments.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Value
@Data
@AllArgsConstructor
public class EnviamentEntregatEvent {
	
	public String enviamentId;

}
