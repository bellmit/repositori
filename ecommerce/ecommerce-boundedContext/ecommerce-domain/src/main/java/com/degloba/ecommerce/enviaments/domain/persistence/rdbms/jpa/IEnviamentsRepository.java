package com.degloba.ecommerce.enviaments.domain.persistence.rdbms.jpa;

import org.springframework.data.jpa.repository.JpaRepository;



/**
 * @category Repositori entitats de persistencia {@link Enviament} implementat en JPA
 * 
 * @author degloba
 */
/////@DomainRepository
//////public interface IEnviamentsRepository extends IEntityRepository {
public interface IEnviamentsRepository extends JpaRepository<Enviament, Long> {    // implementacio amb classes Spring

}
