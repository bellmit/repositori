package com.degloba.ecommerce.enviaments.facade.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

/**
 * 
 * @author degloba
 *
 * @category Data Transfer Object (DTO) d'una entitat {@link Enviament}
 */

//@NoArgsConstructor
@AllArgsConstructor
public class EnviamentDto {
	
	@JsonProperty("enviamentId") @Setter @Getter public String enviamentId;
	@JsonProperty("comandaId") @Setter @Getter public String comandaId;
	@JsonProperty("estat") @Setter @Getter public String estat;
    
	public EnviamentDto() {
		super();
		this.comandaId = "";
		this.estat = "";
		this.enviamentId = "";
		
		// TODO Auto-generated constructor stub
	}
    
    

}
