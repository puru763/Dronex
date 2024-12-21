package com.dronex.drone_service.shared.dto;

import lombok.Data;

import java.util.UUID;


@Data
public class DroneDTO {
    private  String name;
    private UUID siteId;
}
