package com.degloba.ecommerce.vendes.domain.persistence.rdbms.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.degloba.ecommerce.vendes.productes.domain.persistence.rdbms.jpa.Producte;
import com.degloba.ecommerce.vendes.reserves.domain.persistence.rdbms.jpa.Reserva;
import com.degloba.persistence.rdbms.api.jpa.AggregateId;



/**
 * @category Repositori (JPA) de {@link Venda}
 * 
 * @author degloba
 *
 */
//@DomainRepository
//public interface IVendaRepository extends IEntityRepository {
/////@DomainRepository
//////public interface IEnviamentsRepository extends IEntityRepository {
public interface IVendaRepository extends JpaRepository<Producte, Long> {    // implementacio amb classes Spring

	public List<Producte> findProductWhereBestBeforeExpiredIn(int days);
	public Producte obtenirProducteById(Class<Producte> clazz, AggregateId producteId);
	public Reserva obtenirReservaById(Class<Reserva> clazz, AggregateId comandaId);
	

}
