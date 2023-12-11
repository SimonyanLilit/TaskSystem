package com.taskmanagmentsystem.service.impl;

import com.taskmanagmentsystem.dto.requestdto.UserRequestDTO;
import com.taskmanagmentsystem.exceptions.APIException;
import com.taskmanagmentsystem.exceptions.userexceptions.UserAlreadyExistsException;
import com.taskmanagmentsystem.exceptions.userexceptions.UserNotFoundException;

import com.taskmanagmentsystem.model.UserEntity;
import com.taskmanagmentsystem.repository.UserRepository;
import com.taskmanagmentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UserEntity save(UserRequestDTO dto) throws APIException {
        validateDuplicates(dto);


        UserEntity userEntity = new UserEntity();
        userEntity.setId(0);

        userEntity.setPassword(passwordEncoder.encode(dto.getRequestPassword()));
        userEntity.setEmail(dto.getRequestEmail());
        userEntity.setRole(dto.getRequestRole());
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            throw new APIException("problem during saving user");

        }
        return userEntity;

    }



    @Override
    public List<UserEntity> getBYUsername(String email) {
        List<UserEntity> userEntityList = userRepository.getByEmail(email);
        if(userEntityList.isEmpty()){
            throw new UserNotFoundException("user not found");
        }

        return userEntityList;
    }






    @Override

    public void validateDuplicates(UserRequestDTO dto){
        Optional<UserEntity> userEntity=null;
        //post
        if (dto.getId()==null){
            userEntity = userRepository.findByEmail(dto.getRequestEmail());
            if (userEntity.isPresent())
                throw new UserAlreadyExistsException("user already exists");
        }
        //put
        else{
            userEntity = userRepository.findByEmailAndIdNot(dto.getRequestEmail(), dto.getId());
            if (userEntity.isPresent())
                throw new UserAlreadyExistsException("user already exists");
        }
    }



    }
