package com.quotesystem.exceptions.quoteexceptions;

import com.quotesystem.exceptions.QuoteSystemNotFoundException;

public class QuoteNotFoundException extends QuoteSystemNotFoundException {
    public QuoteNotFoundException(String message) {
        super(message);
    }
}
