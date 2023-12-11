package com.taskmanagmentsystem.config;


import com.taskmanagmentsystem.exceptions.userexceptions.UserNotFoundException;
import com.taskmanagmentsystem.model.UserEntity;
import com.taskmanagmentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=null;
        try {
            List<UserEntity> users = userService.getBYUsername(username);
            userEntity=users.get(0);
        }catch (Exception e){
            throw new UserNotFoundException("wrong email "+username);
        }
        Collection<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        return new User(userEntity.getEmail(), userEntity.getPassword(), grantedAuthorities);
    }}
