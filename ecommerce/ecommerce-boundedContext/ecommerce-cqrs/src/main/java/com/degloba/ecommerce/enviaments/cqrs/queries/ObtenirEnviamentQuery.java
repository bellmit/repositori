package com.degloba.ecommerce.enviaments.cqrs.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEnviamentQuery {
	private String enviamentId;

    // constructor and getter
}
