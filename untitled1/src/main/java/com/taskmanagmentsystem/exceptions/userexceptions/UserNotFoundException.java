package com.taskmanagmentsystem.exceptions.userexceptions;


import com.taskmanagmentsystem.exceptions.TaskManagementNotFoundException;

public class UserNotFoundException extends TaskManagementNotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
