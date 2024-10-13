package com.dronex.mission_service.exception;

public class MissionNotExistsException extends RuntimeException{
    public MissionNotExistsException(String message) {
        super(message);
    }

}
