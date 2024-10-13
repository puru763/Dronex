package com.dronex.mission_service.controller;


import com.dronex.mission_service.dto.MissionDTO;
import com.dronex.mission_service.exception.InvalidMissionInputException;
import com.dronex.mission_service.exception.MissionNotExistsException;
import com.dronex.mission_service.service.Missionservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/mission")
public class MissionController {

    @Autowired
    final Missionservice missionservice;

    public MissionController(Missionservice missionservice) {
        this.missionservice = missionservice;
    }


    @PostMapping("/")
    public ResponseEntity<MissionDTO> registerUser(@Valid @RequestBody MissionDTO missionDTO) {
        try {
            MissionDTO createdMission = missionservice.registerMission(missionDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMission);
        } catch (InvalidMissionInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<MissionDTO> getMissionById(@PathVariable UUID id){
        try{
            MissionDTO getMissionById = missionservice.getMissionById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(getMissionById);
        }catch(MissionNotExistsException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<MissionDTO> updateUser(@PathVariable UUID id, @Valid @RequestBody MissionDTO missionDTO) {
        try {
            MissionDTO updatedMission = missionservice.updateMission(id, missionDTO);
            return ResponseEntity.ok(updatedMission);
        } catch (MissionNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (InvalidMissionInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable UUID id) {
        try {
            missionservice.deleteMission(id);
            return ResponseEntity.noContent().build();
        } catch (MissionNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
