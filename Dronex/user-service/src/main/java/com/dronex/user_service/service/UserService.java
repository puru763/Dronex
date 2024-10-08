package com.dronex.user_service.service;

import com.dronex.user_service.dto.UserDTO;

import java.util.UUID;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);

    UserDTO getUserById(UUID id);

    void deleteUser(UUID id);

    UserDTO updateUser(UUID id, UserDTO userDTO);
}
