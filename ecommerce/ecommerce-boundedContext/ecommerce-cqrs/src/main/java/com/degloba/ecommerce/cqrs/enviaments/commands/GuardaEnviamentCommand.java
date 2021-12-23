package com.degloba.ecommerce.cqrs.enviaments.commands;


import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Value
@Data
@AllArgsConstructor
public class GuardaEnviamentCommand {
	
	   public EnviamentDto enviamentDto;

		//////@TargetAggregateIdentifier
		private String enviamentId;

		private String comandaId;
		
		private String estat;

	}
