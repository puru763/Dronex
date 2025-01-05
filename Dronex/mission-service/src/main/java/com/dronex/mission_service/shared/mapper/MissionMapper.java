package com.dronex.mission_service.shared.mapper;

import com.dronex.mission_service.shared.dto.MissionDTO;
import com.dronex.mission_service.data.entity.Mission;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    // Convert MissionDTO to Mission entity
    public  Mission toEntity(MissionDTO missionDTO) {
        if (missionDTO == null) {
            return null;
        }
        Mission mission = new Mission();
        mission.setSiteId(missionDTO.getSiteId());
        mission.setDroneId(missionDTO.getDroneId());
        mission.setWaypoints(missionDTO.getWaypoints());
        mission.setCategoryId(missionDTO.getCategoryId());
        return mission;
    }

    // Convert Mission entity to MissionDTO
    public MissionDTO toDTO(Mission mission) {
        if (mission == null) {
            return null;
        }
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setSiteId(mission.getSiteId());
        missionDTO.setDroneId(mission.getDroneId());
        missionDTO.setWaypoints(mission.getWaypoints());
        missionDTO.setCategoryId(mission.getCategoryId());
        return missionDTO;
    }

    // Update existing Mission entity with values from MissionDTO
    public void updateMission(MissionDTO dto, Mission mission) {
        if (dto == null || mission == null) {
            return;
        }

        if (dto.getSiteId() != null) {
            mission.setSiteId(dto.getSiteId());
        }
        if (dto.getDroneId() != null) {
            mission.setDroneId(dto.getDroneId());
        }
        if (dto.getWaypoints() != null) {
            mission.setWaypoints(dto.getWaypoints());
        }
        if (dto.getCategoryId() != null) {
            mission.setCategoryId(dto.getCategoryId());
        }
    }
}
