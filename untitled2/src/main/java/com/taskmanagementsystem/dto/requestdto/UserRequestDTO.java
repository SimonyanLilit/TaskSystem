package com.taskmanagementsystem.dto.requestdto;

import com.taskmanagementsystem.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private Integer id;

    private  String requestEmail;
    private  String requestPassword;
    private Role requestRole;


}
