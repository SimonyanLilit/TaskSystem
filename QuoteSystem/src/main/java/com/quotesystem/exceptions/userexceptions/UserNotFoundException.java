package com.quotesystem.exceptions.userexceptions;


import com.quotesystem.exceptions.QuoteSystemNotFoundException;

public class UserNotFoundException extends QuoteSystemNotFoundException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
