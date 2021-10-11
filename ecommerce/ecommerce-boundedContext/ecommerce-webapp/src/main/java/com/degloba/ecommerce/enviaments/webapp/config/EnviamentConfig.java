package com.degloba.ecommerce.enviaments.webapp.controllers.impl.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.EnviamentTemplateOperations;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.IEnviamentReactiveRepository;
import com.degloba.ecommerce.enviaments.webapp.controllers.impl.spring.EnviamentReactiveRepository;

/**
 * 
 * @author pere
 * 
 * @category defineix les rutes
 *
 */

@Configuration
public class EnviamentConfig {

  
	/*
	 * @Bean EnviamentRepository enviamentRepository() { return new
	 * EnviamentRepository(); }
	 */
    
    @Bean
    EnviamentTemplateOperations enviamentTemplateOperations() {
        return new EnviamentTemplateOperations();
    }
    
    
	/*
	 * @Bean IEnviamentReactiveRepository enviamentReactiveRepository() { return new
	 * EnviamentReactiveRepository(); }
	 */
    


}
