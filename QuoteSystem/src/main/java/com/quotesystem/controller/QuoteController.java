package com.quotesystem.controller;

import com.quotesystem.dto.requestdto.QuoteRequestDTO;
import com.quotesystem.dto.responsedto.QuoteResponseDTO;
import com.quotesystem.exceptions.APIException;

import com.quotesystem.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @PostMapping("/add")
    public QuoteResponseDTO add(@RequestBody QuoteRequestDTO dto) throws APIException {
        return quoteService.add(dto);
    }

    @PutMapping("/update")
    public QuoteResponseDTO update(@RequestBody QuoteRequestDTO dto) throws APIException {
        return quoteService.update(dto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws APIException {
        quoteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/get-quote/{id}")
    public QuoteResponseDTO getQuote(@PathVariable Integer id){
        return quoteService.getQuote(id);
    }

}
