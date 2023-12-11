package com.taskmanagmentsystem.controller;


import com.taskmanagmentsystem.dto.requestdto.UserRequestDTO;
import com.taskmanagmentsystem.exceptions.APIException;
import com.taskmanagmentsystem.model.UserEntity;
import com.taskmanagmentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
private UserService userService;
    @PostMapping("/save-user")
    public UserEntity savUser(@RequestBody UserRequestDTO requestDTO)throws APIException {
return userService.save(requestDTO);
    }


    @GetMapping("/get-by-username")
    public List<UserEntity> getByUsername(@RequestParam String email){
        return userService.getBYUsername(email);

    }






}
