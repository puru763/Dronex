package com.dronex.site_service.exception;

public class SiteAlreadyExistsException    extends  RuntimeException{
    public SiteAlreadyExistsException(String message) {
        super(message);
    }
}
