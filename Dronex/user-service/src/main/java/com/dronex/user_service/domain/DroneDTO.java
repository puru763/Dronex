package com.dronex.user_service.domain;


import lombok.Data;

import java.util.UUID;

@Data
public class DroneDTO {

    private  String name;

    private UUID siteId;

    public DroneDTO(String fallbackModel, String serviceUnavailable) {
    }

    public DroneDTO() {

    }
}
