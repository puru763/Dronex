package com.dronex.user_service.shared.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {


    @NotEmpty(message = "username can not be a null or empty")
    private String username;

    @NotEmpty(message = "passwordHash can not be a null or empty")
    private String passwordHash;

    @NotEmpty(message = "email can not be a null or empty")
    private String email;

    @NotEmpty(message = "mobileNumber can not be a null or empty")
    private String mobileNumber;
}