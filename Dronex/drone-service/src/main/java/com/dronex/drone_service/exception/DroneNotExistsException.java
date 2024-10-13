package com.dronex.drone_service.exception;

public class DroneNotExistsException   extends RuntimeException{

    public DroneNotExistsException(String message) {
        super(message);
    }
}
