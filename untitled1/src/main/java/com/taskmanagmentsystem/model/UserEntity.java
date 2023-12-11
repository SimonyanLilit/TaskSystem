package com.taskmanagmentsystem.model;

import com.taskmanagmentsystem.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.lang.reflect.Type;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private Integer id;

    private  String email;
    private  String password;
    @Enumerated(EnumType.STRING)
    private Role role;


}
