package com.quotesystem.exceptions.userexceptions;


import com.quotesystem.exceptions.ResourceAlreadyExistsException;

public class UserAlreadyExistsException extends ResourceAlreadyExistsException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
