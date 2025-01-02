package com.dronex.category_service.domain;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {

    @NotEmpty(message = "UserId  can not be a null or empty")

    private UUID Id;


}
