package com.degloba.ecommerce.eventsourcing.enviaments.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;


@Value
@Data
@AllArgsConstructor
public class EnviamentCreatEvent {

	public EnviamentCreatEvent(Enviament e) {
		this.comandaId = "";
		this.enviamentId = "";
		this.estat = "";
		// TODO Auto-generated constructor stub
	}

	@TargetAggregateIdentifier
	public String enviamentId;
	
	public String comandaId;
	
	public String estat;



}
