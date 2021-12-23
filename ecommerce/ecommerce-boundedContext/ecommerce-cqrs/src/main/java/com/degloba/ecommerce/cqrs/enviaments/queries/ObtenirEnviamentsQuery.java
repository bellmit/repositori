package com.degloba.ecommerce.cqrs.enviaments.queries;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObtenirEnviamentsQuery {
	private List<String> enviaments;
}
