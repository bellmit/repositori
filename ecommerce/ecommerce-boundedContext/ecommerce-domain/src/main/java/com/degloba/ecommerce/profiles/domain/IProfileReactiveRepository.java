package com.degloba.ecommerce.profiles.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProfileReactiveRepository extends ReactiveMongoRepository<Profile, String> {
}
