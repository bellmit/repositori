package com.degloba.ecommerce.vendes.infrastructure.persistence.rdbms.api.jpa.repositories;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.degloba.domain.annotations.DomainRepositoryImpl;
import com.degloba.ecommerce.enviaments.domain.persistence.rdbms.jpa.Enviament;
import com.degloba.ecommerce.enviaments.infrastructure.persistence.rdbms.api.jpa.repositories.IEnviamentJPARepository;
import com.degloba.ecommerce.vendes.domain.persistence.rdbms.jpa.IDescompteRepository;
import com.degloba.infrastructure.services.GenericJPARepositoryImpl;
import com.degloba.persistence.rdbms.api.jpa.AggregateId;
import com.degloba.persistence.rdbms.api.jpa.BaseAggregateRoot;
import com.degloba.persistence.rdbms.api.jpa.EntityRepository;


/**
 * @category Repositori (JPA) : Descompte
 * 
 * @author degloba
 *
 */
////@DomainRepositoryImpl
///public class DescompteRepository extends EntityRepository implements IDescompteRepository{
public class DescompteRepository extends SimpleJpaRepository<Enviament, String> implements IEnviamentJPARepository {

	public DescompteRepository(Class<Enviament> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}


}
