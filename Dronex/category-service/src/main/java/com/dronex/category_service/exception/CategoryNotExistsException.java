package com.dronex.category_service.exception;

public class CategoryNotExistsException extends RuntimeException{
    public CategoryNotExistsException(String message) {
        super(message);
    }
}
