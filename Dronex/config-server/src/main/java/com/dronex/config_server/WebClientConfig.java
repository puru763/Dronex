//package com.dronex.config_server;
//
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.Collections;
//
//public class WebClientConfig {
//
//    @LoadBalanced // Enables load balancing on the WebClient
//    public WebClient createWebClient() {
//        return WebClient.builder()
//                .baseUrl("http://your-service-name")
//                .defaultCookie("cookieKey", "cookieValue")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultUriVariables(Collections.singletonMap("url", "http://your-service-name"))
//                .build();
//    }
//}