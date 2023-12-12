package com.quotesystem.dto.requestdto;

import lombok.Data;

@Data
public class QuoteRequestDTO {
    private Integer id;
    private String content;
    private String userEmail;

}
