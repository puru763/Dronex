package com.dronex.drone_service.shared.dto;

import lombok.Data;

import java.util.UUID;


@Data
public class DroneDTO {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getSiteId() {
        return siteId;
    }

    public void setSiteId(UUID siteId) {
        this.siteId = siteId;
    }

    private  String name;
    private UUID siteId;
}
