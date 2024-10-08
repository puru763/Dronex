package com.dronex.site_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(InvalidSiteInputException.class)
    public ResponseEntity<String> handleInvalidSiteInputException(InvalidSiteInputException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(SiteAlreadyExistsException.class)
    public ResponseEntity<String> handleSiteAlreadyExistsException(SiteAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(SiteNotExistsException.class)
    public ResponseEntity<String> handleSiteNotExistsException(SiteNotExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }






}
