package com.dronex.drone_service.shared.mapper;

import com.dronex.drone_service.shared.dto.DroneDTO;
import com.dronex.drone_service.data.entity.Drone;
import org.springframework.stereotype.Component;


@Component
public class DroneMapper {

    public static Drone toEntity(DroneDTO droneDTO) {
        Drone drone = new Drone();
        drone.setName(droneDTO.getName());
        drone.setSiteId(droneDTO.getSiteId());
        return drone;
    }

    public static DroneDTO toDTO(Drone drone) {
        DroneDTO droneDTO = new DroneDTO();
        droneDTO.setName(drone.getName());
        droneDTO.setSiteId(drone.getSiteId());
        return droneDTO;
    }


    public void updateDrone(DroneDTO dto, Drone drone) {
        if (dto.getSiteId() != null) {
            drone.setSiteId(dto.getSiteId());
        }
        if (dto.getName() != null) {
            drone.setName(dto.getName());
        }
    }
}
