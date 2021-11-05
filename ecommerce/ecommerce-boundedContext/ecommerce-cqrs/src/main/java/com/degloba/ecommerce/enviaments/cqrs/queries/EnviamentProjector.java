package com.degloba.ecommerce.enviaments.cqrs.queries;

import java.util.concurrent.CompletableFuture;

import org.axonframework.messaging.ExecutionException;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.degloba.ecommerce.enviaments.application.IEnviamentService;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;


public class EnviamentProjector {

	@Autowired
	IEnviamentService enviamentService;

	public EnviamentProjector(IEnviamentService enviamentService) {
		this.enviamentService = enviamentService;
	}

	@QueryHandler
	public Enviament getLibrary(GetEnviamentQuery query) throws InterruptedException, ExecutionException {
		CompletableFuture<Enviament> future = new CompletableFuture<Enviament>();
		//////libraryRepository.load("" + query.getLibraryId()).execute(future::complete);
		try {
			return future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.util.concurrent.ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
