package com.dronex.mission_service.repository;

import com.dronex.mission_service.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface Missionrepository   extends JpaRepository<Mission , UUID> {
}
