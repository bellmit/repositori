package com.degloba.ecommerce.enviaments.cqrs.finders;


import com.degloba.cqrs.queries.annotations.FinderAnnotation;
import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;

import reactor.core.publisher.Flux;


/**
 * @category un {@link FinderAnnotation} d'{@link Enviament}
 * 
 * @author degloba
 *
 */
@FinderAnnotation
public interface IEnviamentFinder {

	Flux<EnviamentDto> buscaEnviaments();

}
