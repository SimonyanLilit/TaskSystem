package com.quotesystem.dto.requestdto;

import com.quotesystem.enums.Vote;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class VoteRequestDTO {
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Vote vote;
    private Integer quoteId;
    private Integer userId;
}
