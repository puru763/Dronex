package com.dronex.user_service.client;


import com.dronex.user_service.domain.DroneDTO;
import jakarta.inject.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Component
public class DroneServiceClient {
    private final WebClient webClient;

    public DroneServiceClient(@Qualifier("DroneServiceClient") WebClient webClient) {
        this.webClient = webClient;
    }




}
