package com.degloba.ecommerce.productes.persistence.nosql.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.degloba.persistence.domain.sharedkernel.Money;


public class Producte {

    @Id
    private String producteId;
    
	private Money preu;
	
	private String nom;
	
	private TipusProducte tipusProducte;
	
	Producte(String producteId, Money preu, String nom, TipusProducte tipusProducte){
		this.producteId = producteId;
		this.preu = preu;
		this.nom = nom;
		this.tipusProducte = tipusProducte;
	}

}
