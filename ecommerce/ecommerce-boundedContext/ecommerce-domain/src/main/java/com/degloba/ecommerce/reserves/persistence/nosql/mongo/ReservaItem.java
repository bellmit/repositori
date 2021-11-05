package com.degloba.ecommerce.reserves.persistence.nosql.mongo;

import com.degloba.ecommerce.productes.persistence.nosql.mongo.Producte;

public class ReservaItem {


	private Producte producte;
	
	private int quantitat;

	void changeQuantityBy(int change) {
		int changed = quantitat + change;
		if (changed <= 0)
			//throw new DomainOperationException(AggregateId.generate(), "change below 1");
		this.quantitat = changed;
	}
	

	public boolean existed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean notExisted() {
		// TODO Auto-generated method stub
		return false;
	}
}
