package com.dronex.site_service.exception;

public class SiteNotExistsException extends  RuntimeException{
    public SiteNotExistsException(String message) {
        super(message);
    }
}
