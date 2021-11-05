package com.degloba.ecommerce.enviaments.infrastructure.persistence.rdbms.api.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.degloba.domain.persistence.nosql.GenericRepositoryAPI;
import com.degloba.ecommerce.enviaments.domain.persistence.rdbms.jpa.Enviament;


public interface IEnviamentJPARepository extends JpaRepository<Enviament, String> {
		

}
