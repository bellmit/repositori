package com.degloba.ecommerce.enviaments.infrastructure.persistence.rdbms.api.jpa.repositories;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.degloba.domain.annotations.DomainRepositoryImpl;
import com.degloba.ecommerce.enviaments.domain.persistence.rdbms.jpa.Enviament;
import com.degloba.ecommerce.enviaments.domain.persistence.rdbms.jpa.IEnviamentsRepository;
import com.degloba.infrastructure.services.GenericJPARepositoryImpl;
import com.degloba.persistence.rdbms.api.jpa.EntityRepository;


/**
 * @category Repositori (JPA) : {@link Enviament}
 * 
 * @author degloba
 *
 */
////@DomainRepositoryImpl
////public class EnviamentRepository extends EntityRepository implements IEnviamentsRepository{
@Repository
public class EnviamentRepository extends SimpleJpaRepository<Enviament, String> implements IEnviamentJPARepository {

	public EnviamentRepository(Class<Enviament> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}

	


}
