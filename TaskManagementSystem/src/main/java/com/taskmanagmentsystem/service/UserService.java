package com.taskmanagmentsystem.service;

import com.taskmanagmentsystem.dto.requestdto.UserRequestDTO;
import com.taskmanagmentsystem.exceptions.APIException;
import com.taskmanagmentsystem.model.UserEntity;

import java.util.List;

public interface UserService  {
    UserEntity save(UserRequestDTO dto) throws APIException;

    List<UserEntity> getBYUsername(String email);

    void validateDuplicates(UserRequestDTO dto);
}
