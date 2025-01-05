package com.dronex.user_service.service;

import com.dronex.user_service.domain.DroneDTO;
import com.dronex.user_service.shared.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);

    UserDTO getUserById(UUID id);

    void deleteUser(UUID id);

    UserDTO updateUser(UUID id, UserDTO userDTO);

    ResponseEntity<DroneDTO> registerDrone(DroneDTO droneDTO);

    List<UserDTO> getAllDronesByUserId(UUID userId);

    List<UserDTO> getAllSitesByUserId(UUID userId);
}
