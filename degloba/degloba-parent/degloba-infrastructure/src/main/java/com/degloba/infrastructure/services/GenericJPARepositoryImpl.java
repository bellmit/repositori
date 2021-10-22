package com.degloba.infrastructure.services;

import java.io.Serializable;


import org.springframework.stereotype.Service;

@Service
public abstract class GenericJPARepositoryImpl<T, ID extends Serializable> implements GenericJPARepositoryAPI<T, ID> {

	

}
