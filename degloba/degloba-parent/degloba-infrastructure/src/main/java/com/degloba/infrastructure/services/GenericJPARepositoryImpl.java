package com.degloba.infrastructure.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.degloba.domain.persistence.rdbms.GenericJPARepositoryAPI;


@Service
public abstract class GenericJPARepositoryImpl<T, ID extends Serializable> implements GenericJPARepositoryAPI<T, ID> {

	

}
