package com.degloba.ecommerce.enviaments.cqrs.queries;

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
