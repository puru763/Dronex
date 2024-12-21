package com.dronex.drone_service.service.Impl;

import com.dronex.drone_service.shared.dto.DroneDTO;
import com.dronex.drone_service.data.entity.Drone;
import com.dronex.drone_service.exception.DroneNotExistsException;
import com.dronex.drone_service.shared.mapper.DroneMapper;
import com.dronex.drone_service.data.repository.DroneRepository;
import com.dronex.drone_service.service.DroneService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class DroneServiceImpl implements DroneService {

    final DroneRepository droneRepository;
    final DroneMapper droneMapper;

    public DroneServiceImpl(DroneRepository droneRepository, DroneMapper droneMapper) {
        this.droneRepository = droneRepository;
        this.droneMapper = droneMapper;
    }

    @Override
    public DroneDTO registerDrone(DroneDTO droneDTO) {
        Drone drone = DroneMapper.toEntity(droneDTO);
        Drone saveDrone = droneRepository.save(drone);
        return droneMapper.toDTO(saveDrone);
    }

    @Override
    public DroneDTO updatedrone(UUID id, DroneDTO droneDTO) {
            Optional<Drone> existingDrone = droneRepository.findById(id);
            if (!existingDrone.isPresent()) {
                throw new DroneNotExistsException("Drone  does not exist with this ID: " + id);
            }
            Drone drone = existingDrone.get();
        droneMapper.updateDrone(droneDTO, drone);
        System.out.println("Updated User: " + drone);
    Drone updatedDrone = droneRepository.save(drone);
        return droneMapper.toDTO(updatedDrone);
    }

    @Override
    public void deleteDrone(UUID id) {
        Optional<Drone> existingDrone = droneRepository.findById(id);
        if (!existingDrone.isPresent()) {
            throw new DroneNotExistsException("Drone does not exist with this ID: " + id);
        }
        droneRepository.delete(existingDrone.get());

    }

}
