package com.degloba.ecommerce.enviaments.eventsourcing.events;

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
		this.estatEnviament = "";
		// TODO Auto-generated constructor stub
	}

	public String enviamentId;
	
	public String comandaId;
	
	public String estatEnviament;



}
