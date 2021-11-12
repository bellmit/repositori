package com.degloba.ecommerce.facade.impl.assembler;



import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;
import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;

import reactor.core.publisher.Mono;

/**
 * Converteix {@link Enviament} a {@link EnviamentDto}
 * 
 * @author pere
 *
 */
public class EnviamentConverter {
	
	
	public static Mono<EnviamentDto> toDto(Enviament enviament){
	    return Mono.just(new EnviamentDto(enviament.getEnviamentId(), enviament.getComandaId(), 
	    		enviament.getEstat()));
	}
	

}
