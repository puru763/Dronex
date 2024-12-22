package com.dronex.category_service.client;

import com.dronex.category_service.domain.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

public class UserServiceClient {


    private final WebClient webClient;

    public UserServiceClient( WebClient webClient) {
        this.webClient = webClient;
    }

    public ResponseEntity<UserDTO> getAllCategoryByUser(UUID id) {
        return webClient.put()
                .uri(uriBuilder -> uriBuilder.path("/user/{id}")
                        .build(id))
                .retrieve()
                .toEntity(UserDTO.class)
                .block();
    }

}
