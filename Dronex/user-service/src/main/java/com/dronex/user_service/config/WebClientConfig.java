package com.dronex.user_service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean(name = "DroneServiceClient")
    public WebClient droneServiceClient() {
        return WebClient.builder()
                .baseUrl("http://drone-service")
                .build();
    }
}
