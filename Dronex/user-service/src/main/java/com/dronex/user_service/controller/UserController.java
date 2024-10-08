package com.dronex.user_service.controller;


import com.dronex.user_service.dto.UserDTO;
import com.dronex.user_service.exception.InvalidUserInputException;
import com.dronex.user_service.exception.UserNotExistsException;
import com.dronex.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/user")
public class UserController {


    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        try {
            UserDTO createdUser = userService.registerUser(userDTO);
            System.out.println("Received user: " + createdUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (InvalidUserInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID id){
        try{
            UserDTO getUserById = userService.getUserById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(getUserById);
        }catch(UserNotExistsException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable UUID id, @Valid @RequestBody UserDTO userDTO) {
        try {
            UserDTO updatedUser = userService.updateUser(id, userDTO);
            return ResponseEntity.ok(updatedUser);
        } catch (UserNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (InvalidUserInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (UserNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
