package com.dronex.mission_service.exception;

public class InvalidMissionInputException extends RuntimeException{
    public InvalidMissionInputException(String message) {
        super(message);
    }
}
