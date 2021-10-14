package com.degloba.ecommerce.profiles.webapp.services;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.profiles.domain.Profile;
import com.degloba.infrastructure.services.GenericServiceAPI;

/**
 * 
 * @author pere
 *
 */
public interface IProfileServiceAPI extends GenericServiceAPI<Profile, String> {

	ReactiveMongoRepository<Profile, String> getDao();
}
