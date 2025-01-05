package com.dronex.mission_service.shared.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter

public class MissionDTO {

    private UUID id;

    @NotEmpty(message = "Site ID cannot be empty")
    private UUID siteId;

    @NotEmpty(message = "Drone ID cannot be empty")
    private UUID droneId;

    @NotEmpty(message = "Category ID cannot be empty")
    private UUID categoryId;

    private List<String> waypoints;


}
