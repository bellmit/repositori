package com.degloba.ecommerce.enviaments.webreactive.reactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.webreactive.reactive.functional.EnviamentHandler;
import com.degloba.ecommerce.enviaments.webreactive.webflux.EnviamentWebSocketHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import java.util.HashMap;
import java.util.Map;


/**
 * Rutes enviament
 * 
 * @author pere
 *
 */
@Configuration
public class EnviamentWebConfiguration {
		
	@Bean
    RouterFunction<ServerResponse> routes(EnviamentHandler handler) { // <1>
        return RouterFunctions.route(GET("/enviaments"), handler::all)
            .andRoute(GET("/enviaments/{id}"), handler::getById)
            .andRoute(RequestPredicates.DELETE("/enviaments/{id}"), handler::deleteById) // <3>
            .andRoute(POST("/enviaments"), handler::create)
            .andRoute(PUT("/enviaments/{id}"), handler::updateById);
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
    

    
    @Bean
    public HandlerMapping handlerMapping() {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/enviament-feed", new EnviamentWebSocketHandler());

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setUrlMap(map);
        mapping.setOrder(10);
        return mapping;
    }
    
    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

}
