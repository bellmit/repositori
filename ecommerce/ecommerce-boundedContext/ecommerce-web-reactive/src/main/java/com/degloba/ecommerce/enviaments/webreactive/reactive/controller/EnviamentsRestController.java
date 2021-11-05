package com.degloba.ecommerce.enviaments.webreactive.reactive.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;
import com.degloba.ecommerce.enviaments.webreactive.reactive.functional.EnviamentWebClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://ecommerce-webapp-angular:4200")
public class EnviamentsRestController {

	EnviamentWebClientService clientEnviamentsService = new EnviamentWebClientService();

	@RequestMapping("/enviaments/")
	@ResponseBody
	public Flux<EnviamentDto> getEnviaments(@RequestParam(required = false) String queryParam) {
		return clientEnviamentsService.buscarTotsEnviaments(); //// .collectList().block();
	}

	@RequestMapping("/enviaments/add/")
	@ResponseBody
	public void setEnviaments(@RequestParam(required = false) String queryParam) {
		EnviamentDto enviament = new EnviamentDto("7", "8", "9");
		clientEnviamentsService.updateEnviament(enviament);
	}

}
