package com.quotesystem.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.quotesystem.dto.requestdto.QuoteRequestDTO;
import com.quotesystem.dto.responsedto.QuoteResponseDTO;
import com.quotesystem.exceptions.APIException;
import com.quotesystem.exceptions.quoteexceptions.QuoteNotFoundException;
import com.quotesystem.exceptions.userexceptions.UserNotFoundException;
import com.quotesystem.model.QuoteEntity;
import com.quotesystem.model.UserEntity;
import com.quotesystem.model.VoteEntity;
import com.quotesystem.repository.QuoteRepository;
import com.quotesystem.repository.UserRepository;
import com.quotesystem.repository.VoteRepository;
import com.quotesystem.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuoteServiceImpl implements QuoteService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuoteRepository quoteRepository;


    @Override
    public QuoteResponseDTO add(QuoteRequestDTO dto) throws APIException {
        QuoteEntity quoteEntity = new QuoteEntity();
        quoteEntity.setId(0);
        quoteEntity.setContent(dto.getContent());
        quoteEntity.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        quoteEntity.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        List<UserEntity> users = userRepository.getByEmail(dto.getUserEmail());
        if (users.isEmpty())
            throw new UserNotFoundException("user not found with given email");
        quoteEntity.setUserEntity(users.get(0));


        try {
            quoteRepository.save(quoteEntity);
        } catch (Exception e) {
            throw new APIException("problem during saving quote");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        QuoteResponseDTO quoteResponseDTO = objectMapper.convertValue(quoteEntity, QuoteResponseDTO.class);
        return quoteResponseDTO;
    }

    @Override
    public QuoteResponseDTO update(QuoteRequestDTO dto) throws APIException {

        Optional<QuoteEntity> optionalQuote = quoteRepository.findById(dto.getId());
        if (!optionalQuote.isPresent())
            throw new QuoteNotFoundException("quote not found with given id");
        QuoteEntity quoteEntity = optionalQuote.get();
        quoteEntity.setContent(dto.getContent() == null ? quoteEntity.getContent() : dto.getContent());
        quoteEntity.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        try {
            quoteRepository.save(quoteEntity);
        } catch (Exception e) {
            throw new APIException("problem during updating quote");

        }
        ObjectMapper objectMapper = new ObjectMapper();
        QuoteResponseDTO quoteResponseDTO = objectMapper.convertValue(quoteEntity, QuoteResponseDTO.class);
        return quoteResponseDTO;
    }

    @Override
    public void delete(Integer id) throws APIException {
        Optional<QuoteEntity> quoteEntity=null;
        try {

            quoteEntity = quoteRepository.findById(id);
            if (!quoteEntity.isPresent())
                throw new QuoteNotFoundException("quote not found with given id");
            quoteRepository.deleteById(id);
        }catch (Exception e){
            throw new APIException("problem during deleting quote");
        }

    }

    @Override
    public QuoteResponseDTO getQuote(Integer id) {
        Optional<QuoteEntity> quoteOptional=quoteRepository.findById(id);
        if(quoteOptional.isEmpty())
            throw new QuoteNotFoundException("quote not found with given id");
        QuoteEntity quote = quoteOptional.get();
        ObjectMapper objectMapper = new ObjectMapper();
        QuoteResponseDTO quoteResponseDTO = objectMapper.convertValue(quote, QuoteResponseDTO.class);
        return quoteResponseDTO;
    }


}
