package com.degloba.ecommerce.profiles.domain.persistence.nosql.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.degloba.ecommerce.profiles.domain.Profile;

public interface IProfileReactiveRepository extends ReactiveMongoRepository<Profile, String> {
}
