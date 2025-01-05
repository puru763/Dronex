package com.dronex.mission_service.ui.controller;


import com.dronex.mission_service.config.internal.CategoryServiceClient;
import com.dronex.mission_service.shared.dto.MissionDTO;
import com.dronex.mission_service.exception.InvalidMissionInputException;
import com.dronex.mission_service.exception.MissionNotExistsException;
import com.dronex.mission_service.service.Missionservice;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/mission")
public class MissionController {

    private static final Logger logger = LoggerFactory.getLogger(MissionController.class);


    @Autowired
    final Missionservice missionservice;

    public MissionController(Missionservice missionservice) {
        this.missionservice = missionservice;
    }


    @PostMapping
    public ResponseEntity<MissionDTO> registerMission(@Valid @RequestBody MissionDTO missionDTO) {
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
    public ResponseEntity<MissionDTO> updateMission(@PathVariable UUID id, @Valid @RequestBody MissionDTO missionDTO) {
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




    @GetMapping("/{siteId}")
    public ResponseEntity<List<MissionDTO>> getMissionsBySiteId(@PathVariable UUID siteId) {
        try {
            List<MissionDTO> missions = missionservice.getMissionsBySiteId(siteId);
            return ResponseEntity.ok(missions);
        } catch (MissionNotExistsException e) {
            logger.error("No missions found for siteId: {}", siteId, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            logger.error("Invalid input for siteId: {}", siteId, e);
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error("Unexpected error occurred while retrieving missions for siteId: {}", siteId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/{siteId}")
    public ResponseEntity<List<MissionDTO>> getMissionsByCategoryId(@PathVariable UUID categoryId) {
        try {
            List<MissionDTO> missions = missionservice.getMissionsByCategoryId(categoryId);
            return ResponseEntity.ok(missions);
        } catch (MissionNotExistsException e) {
            logger.error("No missions found for categoryId: {}", categoryId, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            logger.error("Invalid input for categoryId: {}", categoryId, e);
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error("Unexpected error occurred while retrieving missions for categoryId: {}", categoryId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }





}
