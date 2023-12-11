package com.taskmanagementsystem.exceptions.userexceptions;


import com.taskmanagementsystem.exceptions.ResourceAlreadyExistsException;

public class UserAlreadyExistsException extends ResourceAlreadyExistsException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
