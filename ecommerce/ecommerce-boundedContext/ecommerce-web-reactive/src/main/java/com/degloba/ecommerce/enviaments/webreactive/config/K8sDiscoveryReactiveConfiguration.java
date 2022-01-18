package com.degloba.ecommerce.enviaments.webreactive.config;


import org.springframework.cloud.kubernetes.discovery.KubernetesDiscoveryClientProperties;
import org.springframework.cloud.kubernetes.discovery.KubernetesReactiveDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuració dels beans necessaris per implementar el servei Discovery client contra Kubernetes
 * 
 * @author pere
 *
 */
@Configuration
public class K8sDiscoveryReactiveConfiguration {
		
    @Bean
    public KubernetesReactiveDiscoveryClient KubernetesReactiveDiscoveryClient(WebClient.Builder webClientBuilder, 
    		KubernetesDiscoveryClientProperties properties) {
    	
    	properties.setDiscoveryServerUrl("wwwwwwwww");

        return new KubernetesReactiveDiscoveryClient(webClientBuilder, properties);
    }
}
