package com.degloba.ecommerce.enviaments.cqrs.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;

import lombok.Getter;
import lombok.Setter;


public class GuardarEnviamentCommand {
	
	   public EnviamentDto enviamentDto;

		public GuardarEnviamentCommand(EnviamentDto e) {
		// TODO Auto-generated constructor stub
			this.enviamentDto = e;
	}
		@Getter @Setter
		@TargetAggregateIdentifier
		private String enviamentId;

		@Getter @Setter
		private String comanda;
		
		@Getter @Setter
		private String estat;

	    // Constructor and getters
	}
