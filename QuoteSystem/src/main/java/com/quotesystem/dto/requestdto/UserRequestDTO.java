package com.quotesystem.dto.requestdto;

import lombok.Data;

import java.sql.Timestamp;

@Data

public class UserRequestDTO {
private Integer requestId;
    private  String requestName;
   private String requestEmail;
    private String requestPassword;

}
