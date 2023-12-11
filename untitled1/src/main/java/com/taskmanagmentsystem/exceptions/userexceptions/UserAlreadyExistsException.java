package com.taskmanagmentsystem.exceptions.userexceptions;


import com.taskmanagmentsystem.exceptions.ResourceAlreadyExistsException;

public class UserAlreadyExistsException extends ResourceAlreadyExistsException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
