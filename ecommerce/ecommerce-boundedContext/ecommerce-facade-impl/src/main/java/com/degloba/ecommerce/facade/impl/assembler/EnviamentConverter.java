package com.degloba.ecommerce.facade.impl.assembler;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;

import reactor.core.publisher.Mono;

public class EnviamentConverter {
	
	
	public static Mono<EnviamentDto> toDto(Enviament enviament){
	    return Mono.just(new EnviamentDto(enviament.getEnviamentId(), enviament.getComandaId(), 
	    		enviament.getEstatEnviament()));
	}
	

}
