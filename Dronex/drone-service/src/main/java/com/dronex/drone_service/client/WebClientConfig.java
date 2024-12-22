package com.dronex.drone_service.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfig {



    @Bean("defaultWebClientBuilder")
    @LoadBalanced
    public WebClient.Builder defaultWebClientBuilder() {
        return  WebClient.builder();
    }


    @Bean("UserServiceClient")
    public WebClient  UserServiceClient( WebClient.Builder webClientBuilder){
        return webClientBuilder.baseUrl("http://user-service").build();
    }
}
