package com.dronex.site_service.config.internal;

import com.dronex.site_service.shared.dto.SiteDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

public class UserServiceClient {

    private  final  WebClient webClient;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceClient.class);

    public UserServiceClient(WebClient webClient) {
        this.webClient = webClient;
    }


    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackgetAllSitesByUserId")
    @Retry(name = "userService")
    @RateLimiter(name = "userService")
    public ResponseEntity<SiteDTO> getAllSitesByUserId(UUID userId) {
        return webClient.get()
                .uri("/api/v1/user/getAllSitesByUserId/{userId}")
                .retrieve()
                .toEntity(SiteDTO.class)
                .block();
    }


    public ResponseEntity<SiteDTO> fallbackgetAllSitesByUserId(SiteDTO siteDTO, Throwable throwable) {
        logger.error("Fallback triggered due to: {}", throwable.getMessage());
        String message = "User service is currently unavailable. Please try again later.";
        SiteDTO fallbackResponse = new SiteDTO(message, "Service Unavailable");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(fallbackResponse);
    }
}
