package com.degloba.ecommerce.enviaments.webapp.reactive.functional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class EnviamentWebConfiguration {
	
		
	@Bean
    RouterFunction<ServerResponse> routes(ProfileHandler handler) { // <1>
        return RouterFunctions.route(RequestPredicates.GET("/enviaments"), handler::all) // <2>
            .andRoute(RequestPredicates.GET("/enviaments/{id}"), handler::getById)
            //.andRoute(RequestPredicates.DELETE("/enviaments/{id}"), handler::deleteById) // <3>
            .andRoute(RequestPredicates.POST("/enviaments"), handler::create)
            .andRoute(RequestPredicates.PUT("/enviaments/{id}"), handler::updateById);
    }
	

    @Bean
    CorsWebFilter corsFilter() {

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        /////config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedOrigin("http://webapp-angular:4200");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
