package com.degloba.ecommerce.enviaments.eventsourcing.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Value
@Data
@AllArgsConstructor
public class EnviamentEliminatEvent {
	
	public String enviamentId;

}