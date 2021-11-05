package com.degloba.ecommerce.enviaments.cqrs.finders.nosql;

import org.springframework.beans.factory.annotation.Autowired;

import com.degloba.cqrs.queries.annotations.FinderAnnotation;
import com.degloba.ecommerce.enviaments.application.IEnviamentService;
import com.degloba.ecommerce.enviaments.cqrs.finders.IEnviamentFinder;
import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;
import com.degloba.ecommerce.facade.impl.assembler.EnviamentConverter;

import reactor.core.publisher.Flux;


/**
 * @author degloba
 *
 * @category es {@link FinderAnnotation} de {@link Enviament}
 * 
 * 
 */
@FinderAnnotation
public class EnviamentFinder implements IEnviamentFinder {

	@Autowired
	IEnviamentService enviamentService;
	
	@Override
    public Flux<EnviamentDto>  buscaEnviaments() {
    	return enviamentService.getAll().flatMap(e -> EnviamentConverter.toDto(e));
    }
}
