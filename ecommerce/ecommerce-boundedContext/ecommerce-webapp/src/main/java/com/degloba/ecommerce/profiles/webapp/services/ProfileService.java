package com.degloba.ecommerce.profiles.webapp.services;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;


import com.degloba.ecommerce.profiles.domain.Profile;
import com.degloba.ecommerce.profiles.domain.persistence.nosql.mongo.IProfileReactiveRepository;
import com.degloba.ecommerce.profiles.eventsourcing.events.ProfileCreatedEvent;
import com.degloba.infrastructure.services.GenericServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class ProfileService extends GenericServiceImpl<Profile, String> implements IProfileServiceAPI {

    private ApplicationEventPublisher publisher; // <1>
    private IProfileReactiveRepository profileRepository; // <2>
    

	@Autowired
	private IProfileReactiveRepository profileReactiveRepository;
	
	@Override
	public ReactiveMongoRepository<Profile, String> getDao() {
		return profileRepository;
	}
	

    ProfileService(ApplicationEventPublisher publisher, IProfileReactiveRepository profileRepository) { 
	  this.publisher = publisher;
	  this.profileRepository = profileRepository; 
	 }
	  
	  public Flux<Profile> all() { // <3> 
		  return this.profileRepository.findAll();
	  }
	  
	  public Mono<Profile> get(String id) { // <4> 
		  return this.profileRepository.findById(id); }
	  
	  public Mono<Profile> update(String id, String email) { // <5> 
		  return this.profileRepository.findById(id).map(p -> new Profile(p.getId(), email))
	  .flatMap(this.profileRepository::save); }
	  
		
      public Mono<Void> delete(String id) { // <6> return return
		  return this.profileRepository.findById(id).flatMap(p ->
		  this.profileRepository.deleteById(p.getId()).then());   //thenReturn(p).);
		  }
		 
	  
	  public Mono<Profile> create(String email) { // <7> 
		  return this.profileRepository.save(new Profile(null, email))
				  .doOnSuccess(profile -> this.publisher.publishEvent(new ProfileCreatedEvent(profile))); }
	 
}