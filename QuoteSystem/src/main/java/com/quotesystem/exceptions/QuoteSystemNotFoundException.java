package com.quotesystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuoteSystemNotFoundException extends RuntimeException{
    public QuoteSystemNotFoundException(String message){super(message);}
}
