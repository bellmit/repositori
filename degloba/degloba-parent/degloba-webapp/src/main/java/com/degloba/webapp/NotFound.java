package com.degloba.webapp;

import org.springframework.web.bind.annotation.ResponseStatus;

////@ResponseStatus(HttpStatus.CONFLICT) // 409
public class NotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long id;
	
	public NotFound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotFound(Long id) {
		super();
		this.id = id;
	}

	
}
