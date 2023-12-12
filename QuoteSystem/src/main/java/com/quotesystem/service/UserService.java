package com.quotesystem.service;

import com.quotesystem.dto.requestdto.UserRequestDTO;
import com.quotesystem.exceptions.APIException;
import com.quotesystem.model.UserEntity;

public interface UserService {
    UserEntity add(UserRequestDTO dto) throws APIException;
}
