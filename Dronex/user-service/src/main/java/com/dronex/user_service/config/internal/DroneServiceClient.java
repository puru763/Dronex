package com.dronex.user_service.config.internal;

import com.dronex.user_service.domain.DroneDTO;


import com.dronex.user_service.service.UserService;
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

@Component
public class DroneServiceClient {
    private final WebClient webClient;

    private static final Logger logger = LoggerFactory.getLogger(DroneServiceClient.class);


    public DroneServiceClient(@Qualifier("droneServiceWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    @CircuitBreaker(name = "droneService", fallbackMethod = "fallbackRegisterDrone")
    @Retry(name = "droneService")
    @RateLimiter(name = "droneService")
    public ResponseEntity<DroneDTO> registerDrone(DroneDTO droneDTO) {
        return webClient.post()
                .uri("/api/v1/drone/register-drone")
                .bodyValue(droneDTO)
                .retrieve()
                .toEntity(DroneDTO.class)
                .block();
    }


    public ResponseEntity<DroneDTO> fallbackRegisterDrone(DroneDTO droneDTO, Throwable throwable) {
        // Log error details
        logger.error("Fallback triggered due to: {}", throwable.getMessage());

        // Return a meaningful response indicating failure
        String message = "Drone service is currently unavailable. Please try again later.";
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new DroneDTO(message, null)); // You can customize the response body as needed
    }


}




//public ResponseEntity<DroneDTO> changeSiteOfDrone(UUID id, DroneDTO droneDTO) {
//    return webClient.put()
//            .uri(uriBuilder -> uriBuilder.path("/drone/{id}")
//                    .build(id))
//            .bodyValue(droneDTO)
//            .retrieve()
//            .toEntity(DroneDTO.class)
//            .block();
//}




