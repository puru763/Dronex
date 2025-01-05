package com.dronex.mission_service.config.internal;

import com.dronex.mission_service.domain.SiteDTO;
import com.dronex.mission_service.shared.dto.MissionDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

public class SiteServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(SiteServiceClient.class);
    private final  WebClient webClient;

    public SiteServiceClient(@Qualifier("siteServiceClient") WebClient webClient) {
        this.webClient = webClient;
    }


//
//    @CircuitBreaker(name ="siteService"  , fallbackMethod = "fallbackgetAllMissionBySiteId")
//    @Retry(name ="siteService")
//    @RateLimiter(name ="siteService")
//   public  ResponseEntity<MissionDTO>getAllMissionBySiteId(@PathVariable UUID siteId){
//       return  webClient.get()
//                .uri("/getAllMissionBySiteId/{siteId}")
//                .retrieve()
//                .toEntity(MissionDTO.class)
//                .block();
//    }
//
//    public ResponseEntity<MissionDTO> fallbackgetAllMissionBySiteId(MissionDTO missionDTO, Throwable throwable) {
//        logger.error("Fallback triggered due to: {}", throwable.getMessage());
//        String message = "Site service is currently unavailable. Please try again later.";
//        MissionDTO fallbackResponse = new MissionDTO(message, "Service Unavailable");
//        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
//                .body(fallbackResponse);
//    }


    @CircuitBreaker(name = "siteService", fallbackMethod = "fallbackGetAllMissionBySiteId")
    @Retry(name = "siteService")
    @RateLimiter(name = "siteService")
    public ResponseEntity<MissionDTO> getAllMissionBySiteId(@PathVariable UUID siteId) {
        return webClient.get()
                .uri("/getAllMissionBySiteId/{siteId}", siteId) // Pass siteId in URI
                .retrieve()
                .toEntity(MissionDTO.class)
                .block();
    }

    public ResponseEntity<MissionDTO> fallbackGetAllMissionBySiteId(UUID siteId, Throwable throwable) {
        logger.error("Fallback triggered due to: {}", throwable.getMessage());
        String message = "Site service is currently unavailable. Please try again later.";
        MissionDTO fallbackResponse = new MissionDTO(message, "Service Unavailable");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(fallbackResponse);
    }






}
