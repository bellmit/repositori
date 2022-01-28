package com.degloba.ecommerce.enviaments.facade.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 
 * @author degloba
 *
 * @category Data Transfer Object (DTO) d'una entitat {@link Enviament}
 */

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class EnviamentDto {
	

//	@JsonProperty("enviamentId") public String enviamentId;
//	@JsonProperty("comandaId") public String comandaId;
//	@JsonProperty("estat") public String estat;
	
	public String enviamentId;
	public String comandaId;
	public String estat;
    

}
