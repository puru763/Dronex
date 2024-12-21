package com.dronex.drone_service.dto;

import lombok.Data;

import java.util.UUID;


@Data
public class DroneDTO {
    private  String name;
    private UUID siteId;
}
