package com.quotesystem.service;

import com.quotesystem.dto.requestdto.QuoteRequestDTO;
import com.quotesystem.dto.responsedto.QuoteResponseDTO;
import com.quotesystem.exceptions.APIException;

public interface QuoteService {
    QuoteResponseDTO add(QuoteRequestDTO dto) throws APIException;
    QuoteResponseDTO update(QuoteRequestDTO dto) throws APIException;
    void delete(Integer id) throws APIException;
    QuoteResponseDTO getQuote(Integer id);

}
