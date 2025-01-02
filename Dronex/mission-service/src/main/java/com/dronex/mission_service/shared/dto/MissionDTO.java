package com.dronex.mission_service.shared.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class MissionDTO {

    @NotEmpty(message = "SiteId  can not be a null or empty")
    private UUID siteId;


    @NotEmpty(message = "DroneId  can not be a null or empty")
    private UUID droneId;

    @NotEmpty(message = "waypoints  can not be a null or empty")
    private List<String> waypoints;

    @NotEmpty(message = "categoryId  can not be a null or empty")
    private UUID categoryId;





    public UUID getSiteId() {
        return siteId;
    }

    public void setSiteId(UUID siteId) {
        this.siteId = siteId;
    }

    public UUID getDroneId() {
        return droneId;
    }

    public void setDroneId(UUID droneId) {
        this.droneId = droneId;
    }

    public List<String> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<String> waypoints) {
        this.waypoints = waypoints;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

}
