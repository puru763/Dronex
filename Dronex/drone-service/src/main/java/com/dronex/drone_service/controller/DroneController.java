package com.dronex.drone_service.controller;


import com.dronex.drone_service.dto.DroneDTO;
import com.dronex.drone_service.exception.DroneNotExistsException;
import com.dronex.drone_service.exception.InvalidDroneInputException;
import com.dronex.drone_service.service.DroneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/drone")
public class DroneController {

public  final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }


    //addDrone
	//getDronesBySite
	//updateDrone
	//deleteDrone


    @PostMapping("/")
    public ResponseEntity<DroneDTO> registerUser(@Valid @RequestBody DroneDTO droneDTO) {
        try {
            DroneDTO createdrone = droneService.registerDrone(droneDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdrone);
        } catch (InvalidDroneInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //getDronesBySite=  this  we  need  to do it   with  web  client




    @PutMapping("/{id}")
    public ResponseEntity<DroneDTO> updateDrone(@PathVariable UUID id, @Valid @RequestBody DroneDTO droneDTO ) {
        try {
            DroneDTO updateDrone = droneService.updatedrone(id, droneDTO);
            return ResponseEntity.ok(updateDrone);
        } catch (DroneNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (InvalidDroneInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrone(@PathVariable UUID id) {
        try {
            droneService.deleteDrone(id);
            return ResponseEntity.noContent().build();
        } catch (DroneNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
