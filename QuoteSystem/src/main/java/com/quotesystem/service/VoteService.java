package com.quotesystem.service;

import com.quotesystem.dto.requestdto.QuoteRequestDTO;
import com.quotesystem.dto.requestdto.VoteRequestDTO;
import com.quotesystem.dto.responsedto.QuoteResponseDTO;
import com.quotesystem.dto.responsedto.VoteResponseDTO;
import com.quotesystem.exceptions.APIException;
import com.quotesystem.model.QuoteEntity;
import com.quotesystem.model.VoteEntity;

import java.util.List;

public interface VoteService {
    VoteResponseDTO vote(VoteRequestDTO dto) throws APIException;
    List<QuoteEntity> getTop10Best();
    List<QuoteEntity> getTop10Worst();
    List<VoteEntity> getHistory(Integer id);
}
