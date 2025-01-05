package com.dronex.mission_service.config.internal;

import com.dronex.mission_service.shared.dto.MissionDTO;
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

public class CategoryServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceClient.class);
    private  final WebClient webClient;

    public CategoryServiceClient(@Qualifier("categoryServiceClient") WebClient webClient) {
        this.webClient = webClient;
    }



    @CircuitBreaker(name ="categoryService" ,  fallbackMethod = "fallbackgetAllMissionByCategoryId")
    @Retry(name ="categoryService")
    @RateLimiter(name ="categoryService")
    public ResponseEntity<MissionDTO>  getAllMissionByCategoryId (UUID missionId){
        return webClient.get()
                .uri("/api/v1/category/getAllMissionByCategoryId/{missionId}", missionId)
                .retrieve()
                .toEntity(MissionDTO.class)
                .block();
    }


    public ResponseEntity<MissionDTO> fallbackgetAllMissionByCategoryId(UUID siteId, Throwable throwable) {
        logger.error("Fallback triggered due to: {}", throwable.getMessage());
        String message = "Site service is currently unavailable. Please try again later.";
        MissionDTO fallbackResponse = new MissionDTO(message, "Service Unavailable");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(fallbackResponse);
    }

}
