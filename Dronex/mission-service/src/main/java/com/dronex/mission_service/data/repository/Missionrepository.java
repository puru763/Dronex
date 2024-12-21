package com.dronex.mission_service.data.repository;

import com.dronex.mission_service.data.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface Missionrepository   extends JpaRepository<Mission , UUID> {
}
