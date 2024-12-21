package com.dronex.user_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
    @NotNull
    private String username;

    @NotNull
    private String passwordHash;

    @NotNull
    private String email;

    @NotNull
    private String mobileNumber;
}