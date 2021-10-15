package com.degloba.ecommerce.profiles.infrastructure.persistence.nosql.mongo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.degloba.ecommerce.profiles.domain.Profile;
import com.degloba.ecommerce.profiles.domain.persistence.nosql.mongo.IProfileReactiveRepository;
import com.degloba.infrastructure.services.GenericRepositoryImpl;


@Repository
public class ProfileReactiveRepository extends GenericRepositoryImpl<Profile, String> implements IProfileReactiveRepository {



}
