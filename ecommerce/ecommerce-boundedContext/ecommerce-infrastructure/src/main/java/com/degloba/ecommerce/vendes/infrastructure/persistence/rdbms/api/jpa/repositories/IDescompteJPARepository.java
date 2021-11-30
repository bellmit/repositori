package com.degloba.ecommerce.vendes.infrastructure.persistence.rdbms.api.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.degloba.domain.persistence.nosql.GenericRepositoryAPI;
import com.degloba.ecommerce.enviaments.domain.persistence.rdbms.jpa.Enviament;
import com.degloba.ecommerce.vendes.ofertes.domain.persistence.rdbms.jpa.Descompte;


public interface IDescompteJPARepository extends JpaRepository<Descompte, String> {
		

}
