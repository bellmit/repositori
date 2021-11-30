package com.degloba.ecommerce.crm.infrastructure.persistence.rdbms.api.jpa.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.degloba.domain.annotations.DomainRepositoryImpl;
import com.degloba.ecommerce.crm.domain.persistence.rdbms.jpa.Client;
import com.degloba.ecommerce.crm.domain.persistence.rdbms.jpa.ICrmRepository;

import com.degloba.infrastructure.services.GenericJPARepositoryImpl;
import com.degloba.infrastructure.services.GenericRepositoryImpl;
import com.degloba.persistence.rdbms.api.jpa.EntityRepository;


/**
 * Repositori + JPA : {@link Crm}
 * 
 * @author degloba
 *
 */
////@DomainRepositoryImpl
////public class CrmRepository extends EntityRepository implements ICrmRepository{
	
public class CrmRepository extends SimpleJpaRepository<Client, String> implements ICrmRepository{

	public CrmRepository(Class<Client> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}



	
}
