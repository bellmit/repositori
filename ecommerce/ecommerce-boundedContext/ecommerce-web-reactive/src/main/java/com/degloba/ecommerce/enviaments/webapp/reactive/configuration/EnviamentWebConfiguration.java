package com.degloba.ecommerce.enviaments.webapp.reactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import com.degloba.ecommerce.enviaments.webapp.reactive.functional.EnviamentHandler;
import com.degloba.ecommerce.enviaments.webapp.webflux.EnviamentWebSocketHandler;
import com.degloba.ecommerce.profiles.webapp.CaseInsensitiveRequestPredicate;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

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
    
    private RequestPredicate i(RequestPredicate target) {
        return new CaseInsensitiveRequestPredicate(target);
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
