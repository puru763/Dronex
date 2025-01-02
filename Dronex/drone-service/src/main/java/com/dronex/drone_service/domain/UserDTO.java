package com.dronex.drone_service.domain;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {

    @NotEmpty(message = "Drone Name  can not be a null or empty")
    private  String name;


    @NotEmpty(message = "SiteId  can not be a null or empty")
    private UUID siteId;
}
