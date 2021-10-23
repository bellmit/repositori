package com.degloba.domain.persistence.rdbms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.degloba.domain.GenericEntity;

/**
 * 
 * @author pere
 *
 * https://ultimate.systems/web/blog/generic-controllers-and-services-in-spring-boot-java
 * 
 * @param <T>
 */
@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity<T>> extends JpaRepository<T, Long> {

}
