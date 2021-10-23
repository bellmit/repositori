package com.degloba.ecommerce.crm.domain.persistence.rdbms.jpa;


import org.springframework.data.jpa.repository.JpaRepository;



/**
 * @author degloba
 * 
 * @category Repository JPA pel CRM
 * 
 */
////@DomainRepository
////public interface ICrmRepository extends IEntityRepository {     // implementacio amb classes degloba
public interface ICrmRepository extends JpaRepository<Client, String> {    // implementacio amb classes Spring

}
