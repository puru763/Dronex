package com.dronex.drone_service.config.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfig {

    @Bean("defaultWebClientBuilder")
    @LoadBalanced
    public WebClient.Builder defaultWebClientBuilder() {
        return WebClient.builder();
    }


    @Bean("userServiceWebClient")
    public WebClient userServiceWebClient(@Qualifier("defaultWebClientBuilder") WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl("http://user-service").build();
    }

}
