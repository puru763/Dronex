package com.dronex.mission_service.mapper;

import com.dronex.mission_service.dto.MissionDTO;
import com.dronex.mission_service.entity.Mission;

public class MissionMapper {

    public static Mission toEntity(MissionDTO missionDTO) {
        Mission mission = new Mission();
        mission.setSiteId(missionDTO.getSiteId());
        mission.setDroneId(missionDTO.getDroneId());
        mission.setWaypoints(missionDTO.getWaypoints());
        mission.setCategoryId(missionDTO.getCategoryId());
        return mission;
    }

    public static MissionDTO toDTO(Mission mission) {
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setSiteId(mission.getSiteId());
        missionDTO.setDroneId(mission.getDroneId());
        missionDTO.setWaypoints(mission.getWaypoints());
        missionDTO.setCategoryId(mission.getCategoryId());
        return missionDTO;
    }


    public void updateMission(MissionDTO dto, Mission mission) {
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
