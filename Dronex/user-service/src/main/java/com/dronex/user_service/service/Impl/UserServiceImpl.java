package com.dronex.user_service.service.Impl;


import com.dronex.user_service.dto.UserDTO;
import com.dronex.user_service.entity.User;
import com.dronex.user_service.exception.UserAlreadyExistsException;
import com.dronex.user_service.exception.UserNotExistsException;
import com.dronex.user_service.mapper.UserMapper;
import com.dronex.user_service.repository.UserRepository;
import com.dronex.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    final UserMapper userMapper;
    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User already exists with email " + userDTO.getEmail());
        }
        User user = userMapper.toEntity(userDTO);
        User savedUser =userRepository.save(user);
        log.info("Registered new user: {}", savedUser.getEmail());
        return userMapper.toDTO(savedUser);
    }


    @Override
    public UserDTO getUserById(UUID id) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            return userMapper.toDTO(existingUser.get());
        } else {
            throw new UserNotExistsException("User does not exist with this ID: " + id);
        }
    }

    @Override
    public UserDTO updateUser(UUID id, UserDTO userDTO) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (!existingUserOptional.isPresent()) {
            throw new UserNotExistsException("User does not exist with this ID: " + id);
        }
        User existingUser = existingUserOptional.get();
        userMapper.updateUser(userDTO, existingUser);
        System.out.println("Updated User: " + existingUser);
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(UUID id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (!existingUser.isPresent()) {
            throw new UserNotExistsException("User does not exist with this ID: " + id);
        }
        userRepository.delete(existingUser.get());
    }


}

