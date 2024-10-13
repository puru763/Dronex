package com.dronex.mission_service.service;

import com.dronex.mission_service.dto.MissionDTO;

import java.util.UUID;

public interface Missionservice {
    MissionDTO registerMission(MissionDTO missionDTO);

    MissionDTO getMissionById(UUID id);

    MissionDTO updateMission(UUID id, MissionDTO missionDTO);

    void deleteMission(UUID id);
}
