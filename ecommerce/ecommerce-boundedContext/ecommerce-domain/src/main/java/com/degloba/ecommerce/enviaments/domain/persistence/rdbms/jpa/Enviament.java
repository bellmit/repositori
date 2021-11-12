package com.degloba.ecommerce.enviaments.domain.persistence.rdbms.jpa;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

import com.degloba.domain.annotations.AggregateRoot;
import com.degloba.ecommerce.enviaments.domain.enums.EstatEnviamentEnum;
import com.degloba.persistence.rdbms.api.jpa.AggregateId;
import com.degloba.persistence.rdbms.api.jpa.BaseAggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @category Entitat de persistencia JPA d'un enviament
 * 
 * @author degloba
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
////@AggregateRoot
public class Enviament { /////////extends BaseAggregateRoot {

	private static final long serialVersionUID = 1L;
	
	private Long enviamentId;
	
	@AttributeOverrides({
		@AttributeOverride(name = "aggregateId", column = @Column(name = "comandaId"))})  
    private Long comandaId;
	
    private EstatEnviamentEnum estatEnviament;

   
    public Enviament(Long enviamentId, Long comandaId) {
        this.enviamentId = enviamentId;
    	this.comandaId = comandaId;
        this.estatEnviament = EstatEnviamentEnum.WAITING;
    }

    /**
     * L'entrega ha estat enviada al client.
     */
    public void envia() {
        if (estatEnviament != EstatEnviamentEnum.WAITING) {
            throw new IllegalStateException("cannot ship in status " + estatEnviament);
        }
        estatEnviament = EstatEnviamentEnum.SENT;
  ////////eventPublisher.publish(new OrderShippedEvent(comandaId, getAggregateId()));
    }

    /**
     * L'entrega ha estat confirmada com a rebuda pel client.
     */
    public void entregar() {
        if (estatEnviament != EstatEnviamentEnum.SENT) {
            throw new IllegalStateException("cannot deliver in status " + estatEnviament);
        }
        estatEnviament = EstatEnviamentEnum.DELIVERED;
        
       // eventPublisher.publish(new EnviamentLliuratEvent(getAggregateId()));
    }

}
