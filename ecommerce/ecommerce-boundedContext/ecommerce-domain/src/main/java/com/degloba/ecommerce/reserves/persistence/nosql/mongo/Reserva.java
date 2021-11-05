package com.degloba.ecommerce.reserves.persistence.nosql.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    private String enviamentId;
    
	/**
	 * @category Estat de la {@link Reserva}	 
	 *
	 */
	public enum EstatReserva{
		OPENED, CLOSED
	}
	
    private EstatReserva status;
    
    private List<ReservaItem> items;
}

