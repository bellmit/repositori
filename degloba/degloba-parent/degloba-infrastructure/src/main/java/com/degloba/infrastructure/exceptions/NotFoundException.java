package com.degloba.infrastructure.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author pere
 *
 * https://ultimate.systems/web/blog/generic-controllers-and-services-in-spring-boot-java
 * 
 * @param <T>
 */
/////@ResponseStatus(code = HttpStatus.CONFLICT) // 409
public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long id;
	
	public NotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(Long id) {
		super();
		this.id = id;
	}

	
}
