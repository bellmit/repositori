package com.degloba.ecommerce.webapp.config;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import java.util.HashMap;
import java.util.Map;

import org.axonframework.commandhandling.AsynchronousCommandBus;
//import org.axonframework.axonserver.connector.command.AxonServerCommandBus;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.distributed.DistributedCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.common.jpa.SimpleEntityManagerProvider;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;
//import org.axonframework.config.Configurer;
//import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.extensions.mongo.DefaultMongoTemplate;
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
//import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
//import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
//import org.axonframework.eventsourcing.eventstore.EventStore;
//import org.axonframework.extensions.mongo.DefaultMongoTemplate;
//import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
//import org.axonframework.eventsourcing.EventSourcingRepository;
//import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
//import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
//import org.axonframework.eventsourcing.eventstore.EventStore;
//import org.axonframework.extensions.reactor.queryhandling.gateway.ReactorQueryGateway;
//import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.messaging.interceptors.CorrelationDataInterceptor;
import org.axonframework.modelling.command.Repository;
//import org.axonframework.modelling.saga.repository.SagaStore;
//import org.axonframework.modelling.saga.repository.jpa.JpaSagaStore;
import org.axonframework.queryhandling.DefaultQueryGateway;
import org.axonframework.queryhandling.QueryBus;
//import org.axonframework.modelling.command.Repository;
//import org.axonframework.modelling.saga.repository.SagaStore;
//import org.axonframework.modelling.saga.repository.jpa.JpaSagaStore;

//import org.axonframework.eventsourcing.EventSourcingRepository;


//import org.axonframework.spring.config.AxonConfiguration;
//import org.axonframework.spring.config.EnableAxon;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SimpleQueryBus;
import org.axonframework.serialization.Serializer;

import org.axonframework.spring.config.AnnotationDriven;
import org.axonframework.spring.config.annotation.AnnotationCommandHandlerBeanPostProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.degloba.ecommerce.cqrs.enviaments.commands.aggregates.EnviamentAggregate;
import com.mongodb.client.MongoClient;


/**
 * Configuració Axon
 * 
 * @author pere
 *
 */

@Configuration
//////////@AnnotationDriven
public class AxonConfiguration {
		
	/*
	 * @Autowired(required = false)
	 * 
	 * @Qualifier("chatRoomRepository") private Repository repository;
	 */


//
//	@Autowired(required = false)
//	private EventStorageEngine eventStorageEngine;

	/*
	 * @Autowired(required = false) private SagaStore sagaStore;
	 */

//	@ConditionalOnMissingBean(ignored = {DistributedCommandBus.class, AxonServerCommandBus.class}, value = CommandBus.class)
//	@Qualifier("localSegment")
//	@Bean
//	public SimpleCommandBus commandBus(TransactionManager txManager, AxonConfiguration axonConfiguration) {
//	  SimpleCommandBus commandBus =
//	      SimpleCommandBus.builder()
//	              .transactionManager(txManager)
//	              .messageMonitor(axonConfiguration.messageMonitor(CommandBus.class, "commandBus"))
//	              .build();
//	  commandBus.registerHandlerInterceptor(
//	      new CorrelationDataInterceptor<>(axonConfiguration.correlationDataProviders())
//	  );
//	  return commandBus;
//	}
	
	
//	@Bean
//	ReactorQueryGateway reactorQueryGateway(ReactorQueryBus queryBus) {
//		DefaultQueryGateway reactorQueryGateway =
//				DefaultQueryGateway.builder().build();
//			
//		
//		return reactorQueryGateway;
//	}
	
//	@Bean
//	 AnnotationCommandHandlerBeanPostProcessor 
//	            annotationCommandHandlerBeanPostProcessor() {
//	       /**
//	        * The AnnotationCommandHandlerBeanPostProcessor 
//	        * finds all beans that has @CommandHandler
//	        * and subscribed them to the commandBus with the 
//	        * first argument of the method being the
//	        * the command type the method will be subscribed to.
//	        */
//	       AnnotationCommandHandlerBeanPostProcessor handler = 
//	               new AnnotationCommandHandlerBeanPostProcessor();
//
////	       handler.ssesetCommandBus(commandBus());
//	       return handler;
//
//	 }
	
	
	@Bean
	CommandBus commandBus() {
		//SimpleCommandBus commandBus = SimpleCommandBus.builder().build();
//			              .transactionManager(txManager)
//			              .messageMonitor(axonConfiguration.messageMonitor(CommandBus.class, "commandBus"))
//			              .build();
//			  commandBus.registerHandlerInterceptor(
//			      new CorrelationDataInterceptor<>(axonConfiguration.correlationDataProviders())
//			  );
		
		AsynchronousCommandBus commandBus = AsynchronousCommandBus.builder().build();
		
		
		////commandBus.subscribe(CreaEnviamentCommand.class.getName(), new EnviamentCommandHandler()); 
		 
		return commandBus;
	}
	
	@Bean
	CommandGateway commandGateway(CommandBus commandBus) {
		DefaultCommandGateway commandGateway =
				DefaultCommandGateway.builder().commandBus(commandBus).build();
					
		return commandGateway;
	}
	
	@Bean
	QueryGateway queryGateway(QueryBus queryBus) {
		DefaultQueryGateway queryGateway =
				DefaultQueryGateway.builder().queryBus(queryBus).build();
		
		return queryGateway;
	}
	
	@Bean
	QueryBus queryBus() {
		SimpleQueryBus queryBus =
				SimpleQueryBus.builder().build();
		
		return queryBus;
	}
	
	
	@Bean
	EventBus eventBus() {
		SimpleEventBus eventBus =
				SimpleEventBus.builder().build();
		
		
		return eventBus;
	}
	
	@Bean
	EventStorageEngine eventStorageEngine() {		
		InMemoryEventStorageEngine eventStorageEngine = new InMemoryEventStorageEngine();	
		
		return eventStorageEngine;
	}
	
	

	
	
//	Configurer axonConfigurer = DefaultConfigurer.defaultConfiguration()
//		    .registerCommandHandler(conf -> new GiftCardCommandHandler());
//	}

	
//    @Bean
//    public EventSourcingRepository<EnviamentAggregate> applicationEventSourcingRepository(EventStore eventStore) {
//        return EventSourcingRepository.builder(EnviamentAggregate.class)
//                        .eventStore(eventStore)
//                        .build();
//   }

//    @Bean
//    public SagaStore sagaStore(EntityManager entityManager) {
//        return JpaSagaStore.builder().entityManagerProvider(new SimpleEntityManagerProvider(entityManager)).build();
//    }
//	
	
	// The Event store `EmbeddedEventStore` delegates actual storage and retrieval of events to an `EventStorageEngine`.
//	@Bean
//	public EmbeddedEventStore eventStore(EventStorageEngine storageEngine, AxonConfiguration configuration) {
//	    return EmbeddedEventStore.builder()
//	            .storageEngine(storageEngine)
//	            .messageMonitor(configuration.messageMonitor(EventStore.class, "eventStore"))
//	            .build();
//	}

	// The `MongoEventStorageEngine` stores each event in a separate MongoDB document
//	@Bean
//	public EventStorageEngine storageEngine(MongoClient client) {
//	    return MongoEventStorageEngine.builder().mongoTemplate(DefaultMongoTemplate.builder().mongoDatabase(client).build()).build();
//	}
	
//	public void contextLoads() {
//		/*assertThat(repository)
//				.isNotNull()
//				.isInstanceOf(GenericJpaRepository.class);*/
//		assertThat(commandGateway)
//				.isNotNull()
//				.isInstanceOf(DefaultCommandGateway.class);
//		assertThat(commandBus)
//				.isNotNull()
//				.isInstanceOf(SimpleCommandBus.class);
//		assertThat(eventBus)
//				.isNotNull()
//				.isInstanceOf(SimpleEventBus.class);
//		assertThat(queryGateway)
//				.isNotNull()
//				.isInstanceOf(DefaultQueryGateway.class);
//		assertThat(sagaStore)
//				.isNotNull()
//				.isInstanceOf(JpaSagaStore.class);
		// assert that we do not have any EventStorageEngine
//		assertThat(eventStorageEngine).isNull();
//	}
	
//	@Qualifier("eventSerializer")
//    @Bean
//    public Serializer eventSerializer() {
//        return new JacksonSerializer()
//    }

	
		  @Bean
		    EventSourcingRepository<EnviamentAggregate> accountAggregateEventSourcingRepository(EventStore eventStore){
		        EventSourcingRepository<EnviamentAggregate> repository = EventSourcingRepository.builder(EnviamentAggregate.class).eventStore(eventStore).build();
		        return repository;
		    }
	
	
	@Bean 
	public EventStorageEngine storageEngine(MongoClient client) {     
		MongoEventStorageEngine m =  MongoEventStorageEngine.builder().mongoTemplate(DefaultMongoTemplate.builder().mongoDatabase(client).build()).build();
		
		return m;
	}
	
	@Bean 
	public EmbeddedEventStore eventStore(EventStorageEngine storageEngine, org.axonframework.spring.config.AxonConfiguration configuration) {     
		return EmbeddedEventStore.builder()             
			.storageEngine(storageEngine)             
			.messageMonitor(configuration.messageMonitor(EventStore.class, "eventStore")).build(); 
	}

}
