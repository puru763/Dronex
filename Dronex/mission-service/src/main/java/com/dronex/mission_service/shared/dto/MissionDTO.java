package com.dronex.mission_service.dto;


import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class MissionDTO {
    private UUID siteId;
    private UUID droneId;
    private List<String> waypoints;
    private UUID categoryId;
}
