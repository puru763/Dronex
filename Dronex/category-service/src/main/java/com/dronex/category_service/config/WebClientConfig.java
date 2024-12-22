package com.dronex.category_service.config;


import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
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
