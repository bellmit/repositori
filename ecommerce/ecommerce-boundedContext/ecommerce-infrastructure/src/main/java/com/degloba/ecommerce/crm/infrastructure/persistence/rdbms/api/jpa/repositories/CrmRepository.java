package com.degloba.ecommerce.crm.infrastructure.persistence.rdbms.api.jpa.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
	
public class CrmRepository extends GenericJPARepositoryImpl<Client, String> implements ICrmRepository{

	
}
