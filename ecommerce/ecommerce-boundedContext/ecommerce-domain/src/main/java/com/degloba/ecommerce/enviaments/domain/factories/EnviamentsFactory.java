package com.degloba.ecommerce.enviaments.domain.factories;

import javax.inject.Inject;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import com.degloba.domain.annotations.DomainFactory;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;


/**
 * @category Fàbrica de {@link Enviament}
 */
@DomainFactory
public class EnviamentsFactory {

    @Inject
    private AutowireCapableBeanFactory spring;

    public Enviament creaEnviament(String comandaId) {
    	///////Key aggregateId = KeyFactory.stringToKey( UUID.randomUUID().toString());
        Enviament enviament = new Enviament("id1", "comandaId", "estat");
        spring.autowireBean(enviament);
        return enviament;
    }
}
