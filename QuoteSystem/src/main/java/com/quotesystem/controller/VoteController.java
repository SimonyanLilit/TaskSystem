package com.quotesystem.controller;

import com.quotesystem.dto.requestdto.VoteRequestDTO;
import com.quotesystem.dto.responsedto.QuoteResponseDTO;
import com.quotesystem.dto.responsedto.VoteResponseDTO;
import com.quotesystem.exceptions.APIException;
import com.quotesystem.model.QuoteEntity;
import com.quotesystem.model.VoteEntity;
import com.quotesystem.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping("/vote")
    public VoteResponseDTO vote(@RequestBody VoteRequestDTO dto) throws APIException {
        return voteService.vote(dto);
    }
    @GetMapping("/get-top10-best")
    List<QuoteEntity> getTop10Best(){
       return voteService.getTop10Best();

    }

    @GetMapping("/get-top10-worst")
    List<QuoteEntity> getTop10Worst(){
        return voteService.getTop10Worst();
    }
    @GetMapping("/get-vote-history/{quote_id}")
    List<VoteEntity> getHistory(@PathVariable Integer quote_id){
        return voteService.getHistory(quote_id);
    }
}
