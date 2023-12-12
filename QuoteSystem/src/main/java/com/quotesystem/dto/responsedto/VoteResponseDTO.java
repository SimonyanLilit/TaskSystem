package com.quotesystem.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.quotesystem.enums.Vote;
import com.quotesystem.model.QuoteEntity;
import com.quotesystem.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder
public class VoteResponseDTO {
    @JsonIgnore
    private Integer id;
    @JsonProperty("vote")
    private Vote vote;
   @JsonProperty("voteDate")
    private Timestamp voteDate;
   @JsonIgnore
    private UserEntity userEntity;
   @JsonProperty("quoteEntity")
    private QuoteResponseDTO quoteResponseDTO ;
}
