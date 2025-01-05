package com.pet_adoption.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdoptionNotFoundException extends RuntimeException{
    public AdoptionNotFoundException(String message) {
        super(message);
    }
}
