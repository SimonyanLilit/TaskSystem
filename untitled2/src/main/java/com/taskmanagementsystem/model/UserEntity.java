package com.taskmanagementsystem.model;

import com.taskmanagementsystem.enums.Role;
import lombok.Data;

import javax.persistence.*;

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
