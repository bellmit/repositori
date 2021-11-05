package com.degloba.ecommerce.enviaments.cqrs.finders.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;

import com.degloba.cqrs.queries.annotations.FinderAnnotation;
import com.degloba.ecommerce.enviaments.cqrs.finders.IEnviamentFinder;
import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;

import reactor.core.publisher.Flux;


/**
 * @author degloba
 *
 * @category es {@link FinderAnnotation} de {@link Enviament}
 * 
 * @implNote JPA
 * 
 */
@FinderAnnotation
public class EnviamentFinder implements IEnviamentFinder {

    @PersistenceContext(name="transactions-optionaldddd")
    @Qualifier(value="entityManagerFactoryDatastore")
    private EntityManager entityManager;

	@Override
    public Flux<EnviamentDto> buscaEnviaments() {
    	throw new RuntimeException("not implemented yet!");
    }
}
