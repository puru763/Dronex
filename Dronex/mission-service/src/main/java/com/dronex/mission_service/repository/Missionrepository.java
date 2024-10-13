package com.dronex.mission_service.repository;

import com.dronex.mission_service.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Missionrepository   extends JpaRepository<Mission , UUID> {
}
