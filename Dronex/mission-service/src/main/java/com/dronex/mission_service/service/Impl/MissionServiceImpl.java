package com.dronex.mission_service.service.Impl;

import com.dronex.mission_service.shared.dto.MissionDTO;
import com.dronex.mission_service.data.entity.Mission;
import com.dronex.mission_service.exception.MissionNotExistsException;
import com.dronex.mission_service.shared.mapper.MissionMapper;
import com.dronex.mission_service.data.repository.Missionrepository;
import com.dronex.mission_service.service.Missionservice;
import com.dronex.mission_service.ui.controller.MissionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class MissionServiceImpl implements Missionservice {

    private static final Logger log = LoggerFactory.getLogger(MissionServiceImpl.class);
    final Missionrepository missionrepository;
    final MissionMapper missionMapper;

    public MissionServiceImpl( Missionrepository missionrepository, MissionMapper missionMapper) {
        this.missionrepository = missionrepository;
        this.missionMapper = missionMapper;
    }
    private static final Logger logger = LoggerFactory.getLogger(MissionController.class);


    @Override
    public MissionDTO registerMission(MissionDTO missionDTO) {
        Mission mission = missionMapper.toEntity(missionDTO);
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

    @Override
    public List<MissionDTO> getMissionsBySiteId(UUID siteId) {
        if (siteId == null) {
            throw new IllegalArgumentException("Site ID cannot be null");
        }
        logger.info("Fetching missions for siteId: {}", siteId);
        List<Mission> missions = missionrepository.findBySiteId(siteId);
        if (missions == null || missions.isEmpty()) {
            logger.warn("No missions found for siteId: {}", siteId);
            throw new MissionNotExistsException("No missions found for site ID: " + siteId);
        }
        return missions.stream()
                .map(missionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MissionDTO> getMissionsByCategoryId(UUID categoryId) {
        if (categoryId == null) {
            throw new IllegalArgumentException("Category ID cannot be null");
        }
        logger.info("Fetching missions for categoryId: {}", categoryId);
        List<Mission> missions = missionrepository.findBySiteId(categoryId);
        if (missions == null || missions.isEmpty()) {
            logger.warn("No missions found for categoryId: {}", categoryId);
            throw new MissionNotExistsException("No missions found for categoryId: " + categoryId);
        }
        return missions.stream()
                .map(missionMapper::toDTO)
                .collect(Collectors.toList());
    }

}
