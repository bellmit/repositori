package com.degloba.ecommerce.enviaments.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import com.degloba.ecommerce.enviaments.application.IEnviamentService;
import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;
import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;

import reactor.core.publisher.Mono;

public class EnviamentAsyncServiceImpl {

	@Autowired
	IEnviamentService enviamentService;
	
	public Mono<EnviamentDto> createVehicleAsync(EnviamentDto enviamentDto) {
		
		CompletableFuture<EnviamentDto> future = CompletableFuture.supplyAsync(() -> {
			Enviament enviament = new Enviament();
	                            enviament.setComandaId(enviamentDto.getComandaId());
	                            enviament.setEstat(enviamentDto.getEstat());
			//enviament = enviamentService.create("","");
			enviamentDto.setEnviamentId(enviament.getEnviamentId());
	        return enviamentDto;
	    });
		
	    Mono<EnviamentDto> monoFromFuture = Mono.fromFuture(future);

	    return monoFromFuture;
	}
}
