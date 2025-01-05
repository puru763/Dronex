package com.dronex.drone_service.config.internal;

import com.dronex.drone_service.domain.UserDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Component
public class UserServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceClient.class);


    private final WebClient webClient;

    public UserServiceClient(@Qualifier("userServiceWebClient") WebClient webClient) {
        this.webClient = webClient;
    }


    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackgetAllDronesByUser")
    @Retry(name = "userService")
    @RateLimiter(name = "userService")
    public ResponseEntity<UserDTO> registerDrone(UUID userId) {
        return webClient.get()
                .uri("/api/v1/user/getAllDroneByUser/{userId}", userId)
                .retrieve()
                .toEntity(UserDTO.class)
                .block();
    }

    public ResponseEntity<UserDTO> fallbackgetAllDronesByUser(UserDTO userDTO, Throwable throwable) {
        logger.error("Fallback triggered due to: {}", throwable.getMessage());

        String message = "user service is currently unavailable. Please try again later.";
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new UserDTO(message, null));
    }









}
