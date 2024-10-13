package com.dronex.drone_service.service;

import com.dronex.drone_service.dto.DroneDTO;

import java.util.UUID;

public interface DroneService {
    DroneDTO registerDrone(DroneDTO droneDTO);


    DroneDTO updatedrone(UUID id, DroneDTO droneDTO);

    void deleteDrone(UUID id);
}
