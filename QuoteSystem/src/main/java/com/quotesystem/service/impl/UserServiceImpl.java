package com.quotesystem.service.impl;

import com.quotesystem.dto.requestdto.UserRequestDTO;
import com.quotesystem.exceptions.APIException;
import com.quotesystem.model.UserEntity;
import com.quotesystem.repository.UserRepository;
import com.quotesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserEntity add(UserRequestDTO dto) throws APIException {
        UserEntity userEntity=new UserEntity();
        userEntity.setId(0);
        userEntity.setName(dto.getRequestName());
        userEntity.setEmail(dto.getRequestEmail());
        userEntity.setPassword(dto.getRequestPassword());
        userEntity.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
try{
    userRepository.save(userEntity);
}catch (Exception e){
    throw new APIException("problem during saving user");
}
return userEntity;
    }
}
