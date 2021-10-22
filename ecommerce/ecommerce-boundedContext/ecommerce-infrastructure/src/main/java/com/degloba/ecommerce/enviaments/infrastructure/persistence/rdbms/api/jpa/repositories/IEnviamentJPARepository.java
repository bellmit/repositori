package com.degloba.ecommerce.enviaments.infrastructure.persistence.rdbms.api.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.degloba.ecommerce.enviaments.domain.persistence.rdbms.jpa.Enviament;
import com.degloba.infrastructure.services.GenericRepositoryAPI;


public interface IEnviamentJPARepository extends JpaRepository<Enviament, String> {
		

}
