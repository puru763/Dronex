package com.dronex.category_service.config.client;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

//    @Bean("defaultWebClientBuilder")
//    @LoadBalanced
//    public WebClient.Builder defaultWebClientBuilder() {
//        return  WebClient.builder();
//    }
//


    @Bean("defaultWebClientBuilder")
    @LoadBalanced
    public WebClient.Builder defaultWebClientBuilder() {
        return WebClient.builder();
    }



    @Bean("droneServiceWebClient")
    public WebClient categoryServiceWebClient(@Qualifier("defaultWebClientBuilder") WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl("http://category-service").build();
    }


}
