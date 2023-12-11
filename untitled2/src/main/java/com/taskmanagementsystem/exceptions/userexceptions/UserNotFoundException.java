package com.taskmanagementsystem.exceptions.userexceptions;


import com.taskmanagementsystem.exceptions.TaskManagementNotFoundException;

public class UserNotFoundException extends TaskManagementNotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
