package com.quotesystem.controller;

import com.quotesystem.dto.requestdto.UserRequestDTO;
import com.quotesystem.exceptions.APIException;
import com.quotesystem.model.UserEntity;
import com.quotesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
   private UserService userService;
    @PostMapping("/add")
    public UserEntity add(@RequestBody UserRequestDTO dto) throws APIException {
        return userService.add(dto);
    }
}
