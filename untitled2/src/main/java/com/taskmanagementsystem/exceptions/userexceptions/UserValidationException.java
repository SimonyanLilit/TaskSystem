package com.taskmanagementsystem.exceptions.userexceptions;


import com.taskmanagementsystem.exceptions.TaskManagementValidationException;

public class UserValidationException extends TaskManagementValidationException {
    public UserValidationException(String message){
        super(message);
    }
}
