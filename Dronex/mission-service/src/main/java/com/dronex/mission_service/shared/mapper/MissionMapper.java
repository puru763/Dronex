package com.dronex.mission_service.shared.mapper;

import com.dronex.mission_service.shared.dto.MissionDTO;
import com.dronex.mission_service.data.entity.Mission;
import org.springframework.stereotype.Component;


@Component
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
