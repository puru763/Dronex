package com.dronex.mission_service.service.Impl;

import com.dronex.mission_service.dto.MissionDTO;
import com.dronex.mission_service.entity.Mission;
import com.dronex.mission_service.exception.MissionNotExistsException;
import com.dronex.mission_service.mapper.MissionMapper;
import com.dronex.mission_service.repository.Missionrepository;
import com.dronex.mission_service.service.Missionservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class MissionServiceImpl implements Missionservice {

    private static final Logger log = LoggerFactory.getLogger(MissionServiceImpl.class);
    final Missionrepository missionrepository;
    final MissionMapper missionMapper;

    public MissionServiceImpl( Missionrepository missionrepository, MissionMapper missionMapper) {
        this.missionrepository = missionrepository;
        this.missionMapper = missionMapper;
    }

    @Override
    public MissionDTO registerMission(MissionDTO missionDTO) {
        Mission mission = MissionMapper.toEntity(missionDTO);
        Mission savedMission =missionrepository.save(mission);
        log.info("Registered new Mission: {}");
        return missionMapper.toDTO(savedMission);
    }


    ///check    here  we  can use  try catch  insted   of  an  if  else  or  not
    @Override
    public MissionDTO getMissionById(UUID id) {
        Optional<Mission> existingUser = missionrepository.findById(id);
        if (existingUser.isPresent()) {
            return missionMapper.toDTO(existingUser.get());
        } else {
            throw new MissionNotExistsException("Mission  does not exist with this ID: " + id);
        }
    }



    @Override
    public MissionDTO updateMission(UUID id, MissionDTO missionDTO) {
        Optional<Mission> existingMission = missionrepository.findById(id);
        if (!existingMission.isPresent()) {
            throw new MissionNotExistsException("Mission  does not exist with this ID: " + id);
        }
        Mission mission = existingMission.get();
        missionMapper.updateMission(missionDTO, mission);
        System.out.println("Updated User: " + mission);
        Mission updatedMission = missionrepository.save(mission);
        return missionMapper.toDTO(updatedMission);
    }

    @Override
    public void deleteMission(UUID id) {
        Optional<Mission> existingUser = missionrepository.findById(id);
        if (!existingUser.isPresent()) {
            throw new MissionNotExistsException("Mission does not exist with this ID: " + id);
        }
        missionrepository.delete(existingUser.get());

    }
}
