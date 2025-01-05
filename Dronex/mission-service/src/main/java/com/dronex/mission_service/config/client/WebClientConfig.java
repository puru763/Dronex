package com.dronex.mission_service.config.client;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    @Bean("defaultWebClientBuilder")
    @LoadBalanced
    public WebClient.Builder defaultWebclientBuilder(){
        return WebClient.builder();
    }



    @Bean("siteServiceClient")
    public  WebClient siteServiceWebClient(@Qualifier("defaultWebClientBuilder") WebClient.Builder webClientBuilder){
        return webClientBuilder.baseUrl("https://site-service").build();
    }

    @Bean("categoryServiceClient")
    public  WebClient categoryServiceWebClient(@Qualifier("defaultWebClientBuilder") WebClient.Builder webClientBuilder){
        return webClientBuilder.baseUrl("https://category-service").build();
    }


}
