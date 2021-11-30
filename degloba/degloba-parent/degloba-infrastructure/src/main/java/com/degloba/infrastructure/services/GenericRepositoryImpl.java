package com.degloba.infrastructure.services;


import java.io.Serializable;

import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.repository.support.*;

import com.degloba.domain.persistence.nosql.GenericRepositoryAPI;


/**
 * 
 * @author pere
 * 
 * https://github.com/spring-projects/spring-data-mongodb/blob/main/spring-data-mongodb/src/main/java/org/springframework/data/mongodb/repository/support/SimpleReactiveMongoRepository.java
 * 
 * https://github.com/PacktPublishing/Hands-On-Reactive-Programming-in-Spring-5/blob/master/chapter-07/section-09-rx-sync/src/main/java/org/rpis5/chapters/chapter_07/wrapped_sync/ReactiveCrudRepositoryAdapter.java
 *
 * @param <T>
 * @param <ID>
 * @param <I>
 */

@Service
public abstract class GenericRepositoryImpl<T, ID extends Serializable, I extends SimpleReactiveMongoRepository<T, ID>> implements GenericRepositoryAPI<T, ID> {
/////public abstract class GenericRepositoryImpl<T, ID extends Serializable> implements GenericRepositoryAPI<T, ID> {
	
	

}
