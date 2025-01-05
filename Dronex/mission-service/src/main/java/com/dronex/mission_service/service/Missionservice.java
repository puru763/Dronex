package com.dronex.mission_service.service;

import com.dronex.mission_service.shared.dto.MissionDTO;

import java.util.List;
import java.util.UUID;

public interface Missionservice {
    MissionDTO registerMission(MissionDTO missionDTO);

    MissionDTO getMissionById(UUID id);

    MissionDTO updateMission(UUID id, MissionDTO missionDTO);

    void deleteMission(UUID id);

    List<MissionDTO> getMissionsBySiteId(UUID siteId);

    List<MissionDTO> getMissionsByCategoryId(UUID categoryId);
}
