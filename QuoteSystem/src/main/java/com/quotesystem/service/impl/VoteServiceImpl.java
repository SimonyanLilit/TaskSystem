package com.quotesystem.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quotesystem.dto.requestdto.VoteRequestDTO;
import com.quotesystem.dto.responsedto.QuoteResponseDTO;
import com.quotesystem.dto.responsedto.VoteResponseDTO;
import com.quotesystem.exceptions.APIException;
import com.quotesystem.exceptions.quoteexceptions.QuoteNotFoundException;
import com.quotesystem.exceptions.userexceptions.UserNotFoundException;
import com.quotesystem.model.QuoteEntity;
import com.quotesystem.model.UserEntity;
import com.quotesystem.model.VoteEntity;
import com.quotesystem.repository.QuoteRepository;
import com.quotesystem.repository.UserRepository;
import com.quotesystem.repository.VoteRepository;
import com.quotesystem.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public VoteResponseDTO vote(VoteRequestDTO dto) throws APIException {
        VoteEntity voteEntity = new VoteEntity();
        Optional<UserEntity> optionalUser = userRepository.findById(dto.getUserId());
        if (optionalUser.isEmpty())
            throw new UserNotFoundException("user not found with given id");
        Optional<QuoteEntity> optionalQuote = quoteRepository.findById(dto.getQuoteId());
        if (optionalQuote.isEmpty())
            throw new QuoteNotFoundException("quote not found with given id");
        voteEntity.setId(0);
        voteEntity.setVote(dto.getVote());
        voteEntity.setUserEntity(optionalUser.get());
        voteEntity.setQuoteEntity(optionalQuote.get());
        voteEntity.setVoteDate(Timestamp.valueOf(LocalDateTime.now()));
        try {
            voteRepository.save(voteEntity);
        } catch (Exception e) {
            throw new APIException("problem during saving vote");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        VoteResponseDTO voteResponseDTO = objectMapper.convertValue(voteEntity, VoteResponseDTO.class);
        return voteResponseDTO;
    }

    @Override
    public List<QuoteEntity> getTop10Best() {
        return quoteRepository.findTop10ByOrderByVotesDesc();
    }

    @Override
    public List<QuoteEntity> getTop10Worst() {
        return quoteRepository.findTop10ByOrderByVotesAsc();
    }

    @Override
    public List<VoteEntity> getHistory(Integer id) {
        return voteRepository.findByQuoteIdOrderByVoteDate(id);

    }


}
