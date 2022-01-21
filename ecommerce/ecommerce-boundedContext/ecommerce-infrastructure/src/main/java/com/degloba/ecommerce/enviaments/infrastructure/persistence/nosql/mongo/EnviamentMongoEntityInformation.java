package com.degloba.ecommerce.enviaments.infrastructure.persistence.nosql.mongo;

import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;

import com.degloba.ecommerce.enviaments.domain.entitats.Enviament;

public class EnviamentMongoEntityInformation implements MongoEntityInformation<Enviament, String> {

	@Override
	public boolean isNew(Enviament entity) {
		return entity.getEnviamentId() == null;
	}

	@Override
	public String getId(Enviament entity) {
		return entity.getEnviamentId();
	}

	@Override
	public Class<String> getIdType() {
		return String.class;
	}

	@Override
	public Class<Enviament> getJavaType() {
		return Enviament.class;
	}

	@Override
	public String getCollectionName() {
		return "customizedEnviament";
	}

	@Override
	public String getIdAttribute() {
		return "id";
	}

	@Override
	public Collation getCollation() {
		return null;
	}
}

