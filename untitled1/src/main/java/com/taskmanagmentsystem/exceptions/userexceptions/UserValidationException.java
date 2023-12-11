package com.taskmanagmentsystem.exceptions.userexceptions;


import com.taskmanagmentsystem.exceptions.TaskManagementValidationException;

public class UserValidationException extends TaskManagementValidationException {
    public UserValidationException(String message){
        super(message);
    }
}
