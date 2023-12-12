package com.quotesystem.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.quotesystem.model.UserEntity;
import com.quotesystem.model.VoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder
public class QuoteResponseDTO {
    @JsonIgnore
    private Integer id;
    @JsonProperty("content")
    private String content;
    @JsonProperty("creationDate")
    private Timestamp creationDate;
    @JsonProperty("updateDate")
    private Timestamp updateDate;
    @JsonProperty("userEntity")
    private UserResponseDTO userResponseDTO;
    @JsonProperty("vote")
    private List<VoteResponseDTO> vote;

}

